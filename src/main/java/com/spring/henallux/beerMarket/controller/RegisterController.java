package com.spring.henallux.beerMarket.controller;

import com.spring.henallux.beerMarket.dataAccess.dao.CategoryDataAccess;
import com.spring.henallux.beerMarket.dataAccess.dao.CustomerDataAccess;
import com.spring.henallux.beerMarket.model.Customer;
import com.spring.henallux.beerMarket.model.OrderLine;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.util.HashMap;

@Controller
@RequestMapping(value = "/register")
@SessionAttributes({Constants.CURRENT_CART})

public class RegisterController extends SuperController{
    private CustomerDataAccess customerDataAccess;

    public RegisterController(CategoryDataAccess categoryDataAccess, CustomerDataAccess customerDataAccess) {
        super(categoryDataAccess);
        this.customerDataAccess = customerDataAccess;
    }

    @RequestMapping (method = RequestMethod.GET)
    public String register (Model model){

        model.addAttribute("categories", super.getAllCategories());
        model.addAttribute("title", "Register");
        model.addAttribute("customer", new Customer());
        if(!model.containsAttribute("cart")){
            model.addAttribute("cart", new HashMap<Integer, OrderLine>());
        }
        return "integrated:register";
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String getFormData (@Valid @ModelAttribute (value = "customer") Customer customerForm, BindingResult errors){
        if (!errors.hasErrors()){
           if(customerForm.getPassword().equals(customerForm.getConfirmationPassword())) {
               BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
               customerForm.setPassword(bCryptPasswordEncoder.encode(customerForm.getPassword()));

               customerForm.setVatNumber(customerForm.getVatNumber().equals("")? null : customerForm.getVatNumber());

               customerForm.setAccountNonLocked(true);
               customerForm.setAccountNonExpired(true);
               customerForm.setEnabled(true);
               customerForm.setCredentialsNonExpired(true);
               customerForm.setAuthorities("ROLE_USER");

               try{
                   customerDataAccess.save(customerForm);
               } catch (Exception e){
                   errors.rejectValue( "email", "email.taken");

                   customerForm.setPassword("");
                   customerForm.setConfirmationPassword("");

                   return "integrated:register";
               }

               customerForm.setPassword("");

               return "integrated:home";
           } else {
               errors.rejectValue("password", "nomatch.password");
               return "integrated:register";
           }
        } else {
            return "integrated:register";
        }
    }
}

package com.spring.henallux.beerMarket.controller;

import com.spring.henallux.beerMarket.dataAccess.dao.CategoryDataAccess;
import com.spring.henallux.beerMarket.model.Customer;
import com.spring.henallux.beerMarket.model.OrderLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.HashMap;

@Controller
@RequestMapping(value = "/toLogin")
@SessionAttributes({Constants.CURRENT_CART})
public class ToLoginController extends SuperController{
    @Autowired
    public ToLoginController(CategoryDataAccess categoryDataAccess){
        super (categoryDataAccess);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String login (Model model) {
        model.addAttribute("customer", new Customer());

        model.addAttribute("categories", super.getAllCategories());
        model.addAttribute("title", "Home");
        if (!model.containsAttribute("cart"))
            model.addAttribute("cart", new HashMap<Integer, OrderLine>());

        return "integrated:home";
    }
}

package com.spring.henallux.beerMarket.controller;

import com.spring.henallux.beerMarket.dataAccess.dao.CategoryDataAccess;
import com.spring.henallux.beerMarket.dataAccess.dao.OrderDataAccess;
import com.spring.henallux.beerMarket.dataAccess.entity.OrderEntity;
import com.spring.henallux.beerMarket.model.Customer;
import com.spring.henallux.beerMarket.model.Discount;
import com.spring.henallux.beerMarket.model.Order;
import com.spring.henallux.beerMarket.model.OrderLine;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;

@Controller
@RequestMapping(value = "/order")
@SessionAttributes({Constants.CURRENT_CART})
public class OrderController extends SuperController {
    private OrderDataAccess orderDataAccess;

    public OrderController(CategoryDataAccess categoryDataAccess, OrderDataAccess orderDataAccess) {
        super(categoryDataAccess);
        this.orderDataAccess = orderDataAccess;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String order (Model model,
                         @ModelAttribute(value = Constants.CURRENT_CART)HashMap <Integer, OrderLine> cart,
                         Authentication authentication){
        model.addAttribute("categories", super.getAllCategories());

        if(cart.isEmpty())
            return "redirect:/cart";

        orderDataAccess.save(new Order(
           new ArrayList<>(cart.values()),
           new GregorianCalendar(), (Customer) authentication.getPrincipal()
        ));
        return "integrated:order";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/success")
    public String success(Model model, @ModelAttribute(value = Constants.CURRENT_CART)HashMap<Integer, OrderLine> cart){
        model.addAttribute("categories", super.getAllCategories());
        cart.clear();

        return "integrated:success";
    }
}

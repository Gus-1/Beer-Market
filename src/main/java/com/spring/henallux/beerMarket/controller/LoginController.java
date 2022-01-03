package com.spring.henallux.beerMarket.controller;

import com.spring.henallux.beerMarket.dataAccess.dao.CategoryDataAccess;
import com.spring.henallux.beerMarket.model.Customer;
import com.spring.henallux.beerMarket.model.OrderLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

public class LoginController extends SuperController{

    @Autowired
    public LoginController(CategoryDataAccess categoryDataAccess){
        super(categoryDataAccess);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String login (Model model, @RequestParam(required = false, value = "error") String error) {
        model.addAttribute("categories", super.getAllCategories());
        model.addAttribute("title", "Login");
        model.addAttribute("customer", new Customer());

        if (!model.containsAttribute("cart")){
            model.addAttribute("cart", new HashMap<Integer, OrderLine>());
        }

        if (error != null){
            model.addAttribute("error", "error");
        }

        return "integrated:login";
    }
}

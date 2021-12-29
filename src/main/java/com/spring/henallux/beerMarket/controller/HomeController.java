package com.spring.henallux.beerMarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value="/")
@SessionAttributes({Constants.CURRENT_CART})
public class HomeController extends SuperController{

    @Autowired
    public HomeController(){}

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model){

        return "integrated:home";
    }
}

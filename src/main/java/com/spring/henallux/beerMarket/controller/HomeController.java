package com.spring.henallux.beerMarket.controller;

import com.spring.henallux.beerMarket.model.OrderLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.HashMap;

@Controller
@RequestMapping(value="/")
@SessionAttributes({Constants.CURRENT_CART})
public class HomeController extends SuperController{

    @Autowired
    public HomeController(){}

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model){


        //Si l'utilisateur est nouveau et n'a toujours pas de panier, on lui en créer un
        if(!model.containsAttribute("cart"))
            model.addAttribute("cart", new HashMap<Integer, OrderLine>());

        return "integrated:home";
    }
}

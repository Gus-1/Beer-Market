package com.spring.henallux.beerMarket.controller;

import com.spring.henallux.beerMarket.dataAccess.dao.CategoryDataAccess;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/privacy")
public class PrivacyController extends SuperController{
    public PrivacyController(CategoryDataAccess categoryDataAccess){
        super(categoryDataAccess);
    }

    @RequestMapping(method= RequestMethod.GET)
    public String privacy(Model model){
        model.addAttribute("title", "Privacy");

        return "static:privacy";
    }
}

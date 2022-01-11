package com.spring.henallux.beerMarket.controller;


import com.spring.henallux.beerMarket.dataAccess.dao.CategoryDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/about")
public class AboutController extends SuperController {

    @Autowired
    public AboutController(CategoryDataAccess categoryDataAccess){
        super(categoryDataAccess);
    }

    @RequestMapping(method= RequestMethod.GET)
    public String privacy(Model model){
        model.addAttribute("title", "About Us");

        return "static:about";
    }
}

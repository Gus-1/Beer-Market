package com.spring.henallux.beerMarket.controller;

import com.spring.henallux.beerMarket.dataAccess.dao.BeerDAO;
import com.spring.henallux.beerMarket.dataAccess.dao.BeerDataAccess;
import com.spring.henallux.beerMarket.dataAccess.dao.CategoryDataAccess;
import com.spring.henallux.beerMarket.dataAccess.repository.BeerRepository;
import com.spring.henallux.beerMarket.dataAccess.repository.CategoryTranslationRepository;
import com.spring.henallux.beerMarket.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/hello")
public class WelcomeController {
    private BeerDataAccess beerDataAccess;
    private CategoryDataAccess categoryDataAccess;

    @Autowired
    public WelcomeController(BeerDataAccess beerDataAccess, CategoryDataAccess categoryDataAccess){
        this.beerDataAccess = beerDataAccess;
        this.categoryDataAccess = categoryDataAccess;
    }


    @RequestMapping(method = RequestMethod.GET)
    public String home (Model model){

        model.addAttribute("title", categoryDataAccess.getAllCategories().get(0).getCategoryId());
        model.addAttribute("magicKeyForm", "value");

        return "integrated:welcome";
    }

    /*@RequestMapping(value = "/send", method = RequestMethod.POST)
    public String getFormData(@ModelAttribute(value="magicKeyForm") MagicKeyFormToDELETE form) {
        if(magicKeyDAO.getMagicKeys().contains(form.getMagicKey())) {
            return "redirect:/inscription";
        }
        else
            return "integrated:keyError";
    }*/
}

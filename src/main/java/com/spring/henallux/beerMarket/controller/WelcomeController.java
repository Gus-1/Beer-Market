package com.spring.henallux.beerMarket.controller;

import com.spring.henallux.beerMarket.dataAccess.dao.MagicKeyDAO;
import com.spring.henallux.beerMarket.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/hello")
public class WelcomeController {
    
    private MagicKeyDataAccess magicKeyDAO;

    @Autowired
    public WelcomeController(MagicKeyDAO magicKeyDAO){
        this.magicKeyDAO = magicKeyDAO;
    }


    @RequestMapping(method = RequestMethod.GET)
    public String home (Model model){
        model.addAttribute("title", "Welcome Page");
        model.addAttribute("magicKeyForm", new MagicKeyFormToDELETE());

        return "integrated:welcome";
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String getFormData(@ModelAttribute(value="magicKeyForm") MagicKeyFormToDELETE form) {
        if(magicKeyDAO.getMagicKeys().contains(form.getMagicKey())) {
            return "redirect:/inscription";
        }
        else
            return "integrated:keyError";
    }
}

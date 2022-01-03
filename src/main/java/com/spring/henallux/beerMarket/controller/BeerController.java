package com.spring.henallux.beerMarket.controller;

import com.spring.henallux.beerMarket.dataAccess.dao.BeerDAO;
import com.spring.henallux.beerMarket.dataAccess.dao.BeerDataAccess;
import com.spring.henallux.beerMarket.dataAccess.repository.BeerRepository;
import com.spring.henallux.beerMarket.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value="/beer")
public class BeerController {

    private BeerDataAccess beerDataAccess;

    @Autowired
    public BeerController(BeerDataAccess beerDataAccess) {
        this.beerDataAccess = beerDataAccess;
    }

    //@RequestMapping (value = "/{beerId}", method = RequestMethod.GET)
    @RequestMapping(method = RequestMethod.GET)
    public String getBeer(Model model) {
        model.addAttribute("beer", beerDataAccess.getBeerById(2));

        return "integrated:beer";
    }

}
package com.spring.henallux.beerMarket.controller;

import com.spring.henallux.beerMarket.dataAccess.dao.BeerDataAccess;
import com.spring.henallux.beerMarket.dataAccess.dao.CategoryDataAccess;
import com.spring.henallux.beerMarket.model.OrderLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.HashMap;

@Controller
@RequestMapping(value = "/details")
@SessionAttributes(Constants.CURRENT_CART)
public class BeersDetailsController extends SuperController {
    private BeerDataAccess beerDataAccess;

    @Autowired
    public BeersDetailsController(BeerDataAccess beerDataAccess, CategoryDataAccess categoryDataAccess) {
        super(categoryDataAccess);
        this.beerDataAccess = beerDataAccess;
    }

    @RequestMapping(value = "/{beerId}", method = RequestMethod.GET)
    public String getBeer(@PathVariable("beerId") Integer beerId, Model model){
        model.addAttribute("categories", super.getAllCategories());
        model.addAttribute("beer", beerDataAccess.getBeerById(beerId));
        model.addAttribute("title", beerDataAccess.getBeerById(beerId).getLabel());
        model.addAttribute("orderLine", new OrderLine());
        if (!model.containsAttribute("cart")){
            model.addAttribute("cart", new HashMap<Integer, OrderLine>());
        }

        return "integrated:beerDetails";
    }
}

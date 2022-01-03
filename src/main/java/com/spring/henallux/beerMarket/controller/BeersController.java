package com.spring.henallux.beerMarket.controller;

import com.spring.henallux.beerMarket.dataAccess.dao.BeerDAO;
import com.spring.henallux.beerMarket.dataAccess.dao.BeerDataAccess;
import com.spring.henallux.beerMarket.dataAccess.dao.CategoryDataAccess;
import com.spring.henallux.beerMarket.dataAccess.repository.BeerRepository;
import com.spring.henallux.beerMarket.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;


@Controller
@RequestMapping(value="/beers")
@SessionAttributes({"cart"})
public class BeersController extends SuperController{
    private BeerDataAccess beerDataAccess;

    @Autowired
    public BeersController(CategoryDataAccess categoryDataAccess, BeerDataAccess beerDataAccess) {
        super(categoryDataAccess);
        this.beerDataAccess = beerDataAccess;
    }

    @RequestMapping (value = "/{beerId}", method = RequestMethod.GET)
    public String getBeers (@PathVariable("category") Integer categoryId, Model model) {
        ArrayList<CategoryTranslation> categories = super.getAllCategories();

        String categoryChosen =  categories.stream().filter(category -> category.getCategoryId().equals(categoryId))
                        .map(CategoryTranslation::getLabel).collect(Collectors.toCollection(ArrayList :: new)).get(0);

        model.addAttribute("categories", categories);
        model.addAttribute("categoryChosen", categoryChosen);
        model.addAttribute("title", "Products");
        model.addAttribute("orderLine", new OrderLine());
        model.addAttribute("beers", beerDataAccess.getAllBeersByCategory(categoryId));
        model.addAttribute("beer", beerDataAccess.getBeerById(2));
        if(!model.containsAttribute("cart")){
            model.addAttribute("cart", new HashMap<Integer, OrderLine>());
        }

        return "integrated:beers";
    }

}
package com.spring.henallux.beerMarket.controller;

import com.spring.henallux.beerMarket.dataAccess.dao.CategoryDataAccess;
import com.spring.henallux.beerMarket.model.CategoryTranslation;

import java.util.ArrayList;

public class SuperController {
    private CategoryDataAccess categoryDataAccess;

    public SuperController(CategoryDataAccess categoryDataAccess){
        this.categoryDataAccess = categoryDataAccess;
    }

    public ArrayList<CategoryTranslation> getAllCategories(){
        return this.categoryDataAccess.getAllCategories();
    }
}

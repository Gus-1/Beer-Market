package com.spring.henallux.beerMarket.dataAccess.dao;


import com.spring.henallux.beerMarket.model.Beer;

import java.util.ArrayList;

public interface BeerDataAccess {
    Beer getBeerById(Integer beerId);
    ArrayList<Beer> getAllBeersByCategory(Integer categoryId);
}

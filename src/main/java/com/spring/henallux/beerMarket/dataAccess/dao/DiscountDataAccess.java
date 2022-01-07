package com.spring.henallux.beerMarket.dataAccess.dao;

import com.spring.henallux.beerMarket.model.Discount;

public interface DiscountDataAccess {
    Discount getDiscountByCode(String code);
}

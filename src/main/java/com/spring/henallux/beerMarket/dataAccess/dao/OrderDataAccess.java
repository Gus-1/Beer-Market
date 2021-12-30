package com.spring.henallux.beerMarket.dataAccess.dao;

import com.spring.henallux.beerMarket.model.Order;

public interface OrderDataAccess {
    Order save(Order order);
}

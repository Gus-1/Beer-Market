package com.spring.henallux.beerMarket.dataAccess.entity;

import java.io.Serializable;

public class OrderLineId implements Serializable {
    private OrderEntity orderEntity;
    private BeerEntity beerEntity;

    public OrderLineId(){}

    public OrderLineId(OrderEntity orderEntity, BeerEntity beerEntity){
        this.orderEntity = orderEntity;
        this.beerEntity = beerEntity;
    }
}

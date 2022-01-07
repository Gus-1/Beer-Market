package com.spring.henallux.beerMarket.dataAccess.entity;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Embeddable
public class OrderLineId implements Serializable {
    @JoinColumn(name="order_id", referencedColumnName = "order_id")
    @ManyToOne
    private OrderEntity orderEntity;
    @JoinColumn(name="beer_id", referencedColumnName = "beer_id")
    @ManyToOne
    private BeerEntity beerEntity;

    public OrderLineId(){}

    public OrderLineId(OrderEntity orderEntity, BeerEntity beerEntity){
        this.orderEntity = orderEntity;
        this.beerEntity = beerEntity;
    }

    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }

    public BeerEntity getBeerEntity() {
        return beerEntity;
    }

    public void setBeerEntity(BeerEntity beerEntity) {
        this.beerEntity = beerEntity;
    }
}

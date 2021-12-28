package com.spring.henallux.beerMarket.model;

//todo : A voir dans le schéma de la DB si tout est bon
public class OrderLine {
    private Beer beer;
    private Integer quantity;

    public OrderLine(){}

    public OrderLine(Beer beer, Integer quantity){
        this.beer = beer;
        this.quantity = quantity;
    }

    public Beer getBeer() {
        return beer;
    }

    public void setBeer(Beer beer) {
        this.beer = beer;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
package com.spring.henallux.beerMarket.dataAccess.entity;

import com.spring.henallux.beerMarket.model.OrderLine;

import javax.persistence.*;

@Entity
@Table(name="order_line")
public class OrderLineEntity {

    @Id
    @JoinColumn(name="order_id", referencedColumnName = "order_id")
    @ManyToOne
    private OrderEntity orderId;

    @Id
    @JoinColumn(name="beer_id", referencedColumnName = "beer_id")
    @ManyToOne
    private BeerEntity beerId;

    @Column(name="order_line_number")
    private Integer orderLineNumber;

    @Column(name="quantity")
    private Integer quantity;

    @Column(name="price")
    private Double price;

    public OrderLineEntity(){}

    public OrderLineEntity(OrderEntity orderId, BeerEntity beerId, Integer orderLineNumber, Integer quantity, Double price) {
        this.orderId = orderId;
        this.beerId = beerId;
        this.orderLineNumber = orderLineNumber;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderEntity getOrderId() {
        return orderId;
    }

    public void setOrderId(OrderEntity orderId) {
        this.orderId = orderId;
    }

    public BeerEntity getBeerId() {
        return beerId;
    }

    public void setBeerId(BeerEntity beerId) {
        this.beerId = beerId;
    }

    public Integer getOrderLineNumber() {
        return orderLineNumber;
    }

    public void setOrderLineNumber(Integer orderLineNumber) {
        this.orderLineNumber = orderLineNumber;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

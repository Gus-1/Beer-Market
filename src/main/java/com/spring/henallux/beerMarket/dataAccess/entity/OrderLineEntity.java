package com.spring.henallux.beerMarket.dataAccess.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="orderLine")
public class OrderLineEntity {

    @Id
    private OrderLineId orderLineId;

    @JoinColumn(name="orderId", referencedColumnName = "orderId")
    @ManyToOne
    private OrderEntity orderId;

    @JoinColumn(name="beerId", referencedColumnName = "beerId")
    @ManyToOne
    private BeerEntity beerId;

    @Column(name="orderLineNumber")
    private Integer orderLineNumber;

    @Column(name="quantity")
    private Integer quantity;

    @Column(name="price")
    private Double price;

    public OrderLineEntity(){}

    public OrderLineEntity(OrderLineId orderLineId, OrderEntity orderId, BeerEntity beerId, Integer orderLineNumber, Integer quantity, Double price) {
        this.orderLineId = orderLineId;
        this.orderId = orderId;
        this.beerId = beerId;
        this.orderLineNumber = orderLineNumber;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderLineId getOrderLineId() {
        return orderLineId;
    }
    public void setOrderLineId(OrderLineId orerLineId) {
        this.orderLineId = orerLineId;
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

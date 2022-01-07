package com.spring.henallux.beerMarket.dataAccess.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="orderline")
public class OrderLineEntity {

    @EmbeddedId
    private OrderLineId orderLineId;

    @Column(name="order_line_number")
    private Integer orderLineNumber;

    @Column(name="quantity")
    private Integer quantity;

    @Column(name="price")
    private Double price;

    public OrderLineEntity(){}

    public OrderLineEntity(OrderLineId orderLineId, OrderEntity orderId, BeerEntity beerId, Integer orderLineNumber, Integer quantity, Double price) {
        this.orderLineId = orderLineId;
        this.orderLineNumber = orderLineNumber;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderLineId getOrderLineId() {
        return orderLineId;
    }
    public void setOrderLineId(OrderLineId orderLineId) {
        this.orderLineId = orderLineId;
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

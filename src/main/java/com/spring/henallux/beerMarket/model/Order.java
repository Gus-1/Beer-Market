package com.spring.henallux.beerMarket.model;

import java.util.GregorianCalendar;
import java.util.List;

public class Order {
    private Integer orderId;
    private List<OrderLine> orderLines;
    private GregorianCalendar orderDate;
    private Customer customer;
    private Float VAT;

    public Order(){}

    public Order(List<OrderLine> orderLines, GregorianCalendar orderDate, Customer customer){
        this.orderLines = orderLines;
        this.orderDate = orderDate;
        this.customer = customer;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public GregorianCalendar getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(GregorianCalendar orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Float getVAT() {
        return VAT;
    }

    public void setVAT(Float VAT) {
        this.VAT = VAT;
    }
}

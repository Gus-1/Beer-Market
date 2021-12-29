package com.spring.henallux.beerMarket.dataAccess.entity;


import javax.persistence.*;
import java.util.Date;
import java.util.GregorianCalendar;

@Entity
@Table(name="order")
public class OrderEntity {
    @Id
    @Column(name="order_id")
    private Integer orderId;

    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    @ManyToOne
    private CustomerEntity customer;

    @JoinColumn(name = "discount_id", referencedColumnName = "discount_id")
    @ManyToOne
    private DiscountEntity discount;

    @Column(name="order_date")
    private Date date;

    @Column(name="vat")
    private Double vat;

    public OrderEntity(){}

    public OrderEntity(Integer orderId, CustomerEntity customer, DiscountEntity discount, Date date, Double vat) {
        this.orderId = orderId;
        this.customer = customer;
        this.discount = discount;
        this.date = date;
        this.vat = vat;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public DiscountEntity getDiscount() {
        return discount;
    }

    public void setDiscount(DiscountEntity discount) {
        this.discount = discount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getVat() {
        return vat;
    }

    public void setVat(Double vat) {
        this.vat = vat;
    }
}

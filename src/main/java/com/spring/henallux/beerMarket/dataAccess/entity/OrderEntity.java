package com.spring.henallux.beerMarket.dataAccess.entity;


import javax.persistence.*;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Entity
@Table(name="orders")
public class OrderEntity {

    @Id
    @Column(name="orderId")
    private Integer orderId;

    @OneToMany
    private List<OrderLineEntity> orderLineEntities;

    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    @ManyToOne
    private CustomerEntity customer;

    @JoinColumn(name = "discountId", referencedColumnName = "discountId")
    @ManyToOne
    private DiscountEntity discount;

    @Column(name="orderDate")
    private Date date;

    @Column(name="VAT")
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

    public List<OrderLineEntity> getOrderLineEntities() {
        return orderLineEntities;
    }

    public void setOrderLineEntities(List<OrderLineEntity> orderLineEntities) {
        this.orderLineEntities = orderLineEntities;
    }
}

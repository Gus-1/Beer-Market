package com.spring.henallux.beerMarket.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order_line")
public class OrderLineEntity {
    @Id
    @Column(name="order_id")
    private Integer orderId;

}

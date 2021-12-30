package com.spring.henallux.beerMarket.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="discount")
public class DiscountEntity {
    @Id
    @Column(name="discountId")
    private Integer discountId;

    @Column(name="code")
    private String code;

    @Column(name="reduction")
    private Integer reduction;
}

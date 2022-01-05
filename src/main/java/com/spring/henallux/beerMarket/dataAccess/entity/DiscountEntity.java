package com.spring.henallux.beerMarket.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="discount")
public class DiscountEntity {
    @Id
    @Column(name="discount_id")
    private Integer discountId;

    @Column(name="code")
    private String code;

    @Column(name="reduction")
    private Integer reduction;

    public DiscountEntity() {}

    public Integer getDiscountId() { return discountId; }

    public String getCode() { return code; }

    public Integer getReduction() { return reduction; }

    public void setDiscountId(Integer discountId) { this.discountId = discountId; }

    public void setCode(String code) { this.code = code; }

    public void setReduction(Integer reduction) { this.reduction = reduction; }

}

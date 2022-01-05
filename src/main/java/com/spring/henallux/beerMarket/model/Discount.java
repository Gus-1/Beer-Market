package com.spring.henallux.beerMarket.model;

public class Discount {

    private Integer discountId;
    private String code;
    private Integer reduction;

    public Discount() {}

    public Integer getDiscountId() { return discountId; }

    public String getCode() { return code; }

    public Integer getReduction() { return reduction; }

    public void setDiscountId(Integer discountId) { this.discountId = discountId; }

    public void setCode(String code) { this.code = code; }

    public void setReduction(Integer reduction) { this.reduction = reduction; }


}

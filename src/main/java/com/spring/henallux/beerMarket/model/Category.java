package com.spring.henallux.beerMarket.model;

public class Category {
    private Integer categoryId;

    public Category(){}

    public Category(Integer categoryId){
        this.categoryId = categoryId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

}

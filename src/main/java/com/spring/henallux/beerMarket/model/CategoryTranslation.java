package com.spring.henallux.beerMarket.model;


public class CategoryTranslation {
    private Integer categoryId;
    private Integer languageId;
    private String label;

    public CategoryTranslation(){}

    public CategoryTranslation(Integer categoryId, Integer languageId, String label) {
        this.categoryId = categoryId;
        this.languageId = languageId;
        this.label = label;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}

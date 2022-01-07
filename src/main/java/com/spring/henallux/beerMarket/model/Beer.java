package com.spring.henallux.beerMarket.model;

import javax.validation.constraints.Positive;

public class Beer {
    private Integer beerId;
    private String label;
    private String description;
    @Positive
    private Double price;
    private String flavour;
    private String brewery;
    private String originCountry;
    private String imagePath;
    private Double abv;
    private Category category;

    public Beer(){}

    public Beer(Integer beerId, String label, String description, Double price, String flavour, String brewery, String originCountry,
                String imagePath, Double abv, Category category){
        this.beerId = beerId;
        this.label = label;
        this.description = description;
        this.price = price;
        this.flavour = flavour;
        this.brewery = brewery;
        this.originCountry = originCountry;
        this.imagePath = imagePath;
        this.abv = abv;
        this.category = category;
    }

    public Integer getBeerId() {
        return beerId;
    }

    public void setBeerId(Integer beerId) {
        this.beerId = beerId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    public String getBrewery() {
        return brewery;
    }

    public void setBrewery(String brewery) {
        this.brewery = brewery;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Double getAbv() {
        return abv;
    }

    public void setAbv(Double abv) {
        this.abv = abv;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    @Override
    public boolean equals(Object obj) {
        return obj instanceof Beer && ((Beer) obj).getBeerId().equals(getBeerId()) &&
                ((Beer) obj).getLabel().equals(getLabel()) &&
                ((Beer) obj).getBrewery().equals(getBrewery()) &&
                ((Beer) obj).getOriginCountry().equals(getOriginCountry()) &&
                ((Beer) obj).getFlavour().equals(getFlavour()) &&
                ((Beer) obj).getAbv().equals(getAbv()) &&
                ((Beer) obj).getImagePath().equals(getImagePath()) &&
                ((Beer) obj).getDescription().equals(getDescription()) &&
                ((Beer) obj).getPrice().equals(getPrice()) &&
                ((Beer) obj).getCategory().equals(getCategory());
    }
}

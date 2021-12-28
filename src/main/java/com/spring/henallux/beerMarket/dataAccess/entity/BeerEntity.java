package com.spring.henallux.beerMarket.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="beer")
public class BeerEntity {

    @Id
    @Column(name="beer_id")
    private Integer beerId;

    @Column(name="label")
    private String label;

    @Column(name="description")
    private String description;

    @Column(name="abv")
    private Double abv;

    @Column(name="flavour")
    private String flavour;

    @Column(name="brewery")
    private String brewery;

    @Column(name="origin_country")
    private String originCountry;

    @Column(name="image_path")
    private String imagePath;

    @Column(name="price")
    private Double price;

    @JoinColumn(name="category_id", referencedColumnName = "category_id")
    @ManyToOne
    private CategoryEntity categoryEntity;

    public BeerEntity() {
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

    public Double getAbv() {
        return abv;
    }

    public void setAbv(Double abv) {
        this.abv = abv;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }
}

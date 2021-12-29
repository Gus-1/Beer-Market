package com.spring.henallux.beerMarket.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="category_translation")
public class TranslationCategoryEntity {
    @Id
    @JoinColumn(name="category_id", referencedColumnName = "category_id")
    @ManyToOne
    private CategoryEntity categoryId;

    @Id
    @JoinColumn(name="language_id", referencedColumnName = "language_id")
    @ManyToOne
    private LanguageEntity languageEntity;

    @Column(name="label")
    private String label;

    public TranslationCategoryEntity(){}

    public CategoryEntity getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(CategoryEntity categoryId) {
        this.categoryId = categoryId;
    }

    public LanguageEntity getLanguageEntity() {
        return languageEntity;
    }

    public void setLanguageEntity(LanguageEntity languageEntity) {
        this.languageEntity = languageEntity;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}

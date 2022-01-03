package com.spring.henallux.beerMarket.dataAccess.entity;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class TranslationCategoryId implements Serializable {

    @JoinColumn(name="category_id", referencedColumnName = "category_id")
    @ManyToOne
    private CategoryEntity categoryId;
    @JoinColumn(name="language_id", referencedColumnName = "language_id")
    @ManyToOne
    private LanguageEntity languageEntity;

    public TranslationCategoryId() {}

    public TranslationCategoryId(CategoryEntity categoryId, LanguageEntity languageEntity) {
        this.categoryId = categoryId;
        this.languageEntity = languageEntity;
    }

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
}

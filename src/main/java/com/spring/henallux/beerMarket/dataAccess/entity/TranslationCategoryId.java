package com.spring.henallux.beerMarket.dataAccess.entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class TranslationCategoryId implements Serializable {

    private CategoryEntity categoryId;
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

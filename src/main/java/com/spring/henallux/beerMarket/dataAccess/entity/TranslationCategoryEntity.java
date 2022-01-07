package com.spring.henallux.beerMarket.dataAccess.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="category_translation")
public class TranslationCategoryEntity {

    @EmbeddedId
    private TranslationCategoryId translationCategoryId;

    @Column(name="label")
    private String label;

    public TranslationCategoryEntity(){}

    public TranslationCategoryId getTranslationCategoryId() {
        return translationCategoryId;
    }

    public void setTranslationCategoryId(TranslationCategoryId translationCategoryId) {
        this.translationCategoryId = translationCategoryId;
    }

    /*public CategoryEntity getCategoryId() {
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
    }*/

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}

package com.spring.henallux.beerMarket.dataAccess.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="categoryTranslation")
public class TranslationCategoryEntity {

    @Id
    private TranslationCategoryId translationCategoryId;

    @JoinColumn(name="categoryId", referencedColumnName = "categoryId")
    @ManyToOne
    private CategoryEntity categoryId;

    @JoinColumn(name="languageId", referencedColumnName = "languageId")
    @ManyToOne
    private LanguageEntity languageEntity;

    @Column(name="label")
    private String label;

    public TranslationCategoryEntity(){}

    public TranslationCategoryId getTranslationCategoryId() {
        return translationCategoryId;
    }

    public void setTranslationCategoryId(TranslationCategoryId translationCategoryId) {
        this.translationCategoryId = translationCategoryId;
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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}

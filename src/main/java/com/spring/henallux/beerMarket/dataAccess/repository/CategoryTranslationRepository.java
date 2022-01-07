package com.spring.henallux.beerMarket.dataAccess.repository;

import com.spring.henallux.beerMarket.dataAccess.entity.CategoryEntity;
import com.spring.henallux.beerMarket.dataAccess.entity.TranslationCategoryEntity;
import com.spring.henallux.beerMarket.dataAccess.entity.TranslationCategoryId;
import com.spring.henallux.beerMarket.model.CategoryTranslation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryTranslationRepository extends JpaRepository<TranslationCategoryEntity, TranslationCategoryId> {
    List <TranslationCategoryEntity> findAllByTranslationCategoryId_LanguageEntity_LanguageName(String languageName);
}

package com.spring.henallux.beerMarket.dataAccess.repository;

import com.spring.henallux.beerMarket.dataAccess.entity.CategoryEntity;
import com.spring.henallux.beerMarket.dataAccess.entity.TranslationCategoryEntity;
import com.spring.henallux.beerMarket.dataAccess.entity.TranslationCategoryId;
import com.spring.henallux.beerMarket.model.CategoryTranslation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
}

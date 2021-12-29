package com.spring.henallux.beerMarket.dataAccess.repository;

import com.spring.henallux.beerMarket.dataAccess.entity.CategoryEntity;
import com.spring.henallux.beerMarket.dataAccess.entity.TranslationCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//todo : Vérifier les types
@Repository
public interface CategoryRepository extends JpaRepository<TranslationCategoryEntity, CategoryEntity> {

}

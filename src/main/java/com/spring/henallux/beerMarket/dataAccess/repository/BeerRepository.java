package com.spring.henallux.beerMarket.dataAccess.repository;

import com.spring.henallux.beerMarket.dataAccess.entity.BeerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeerRepository extends JpaRepository<BeerEntity, Integer>{
    BeerEntity findBeerEntityByBeerId(Integer beerId);
    List<BeerEntity> findBeerEntitiesByCategoryEntityCategoryId (Integer categoryId);
}

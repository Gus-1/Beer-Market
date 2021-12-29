package com.spring.henallux.beerMarket.dataAccess.dao;

import com.spring.henallux.beerMarket.dataAccess.entity.BeerEntity;
import com.spring.henallux.beerMarket.dataAccess.repository.BeerRepository;
import com.spring.henallux.beerMarket.dataAccess.util.ProviderConverter;
import com.spring.henallux.beerMarket.model.Beer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BeerDAO implements BeerDataAccess{

    private BeerRepository repository;
    private ProviderConverter converter;

    public BeerDAO(BeerRepository repository, ProviderConverter converter){
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public Beer getBeerById(Integer beerId) {
        BeerEntity beerEntity = repository.findBeerEntityByBeerId(beerId);
        return convertBeer(beerEntity);
    }


    private Beer convertBeer(BeerEntity beerEntity){
        Beer beer = converter.beerEntityToBeerModel(beerEntity);
        beer.setCategory(converter.categoryEntityToCategoryModel(beerEntity.getCategoryEntity()));
        return beer;
    }
}

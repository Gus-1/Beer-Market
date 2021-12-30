package com.spring.henallux.beerMarket.dataAccess.dao;

import com.spring.henallux.beerMarket.dataAccess.entity.BeerEntity;
import com.spring.henallux.beerMarket.dataAccess.repository.BeerRepository;
import com.spring.henallux.beerMarket.dataAccess.util.ProviderConverter;
import com.spring.henallux.beerMarket.model.Beer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BeerDAO implements BeerDataAccess{

    private BeerRepository beerRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public BeerDAO(BeerRepository repository, ProviderConverter providerConverter){
        this.beerRepository = repository;
        this.providerConverter = providerConverter;
    }

    public Beer getBeerById(Integer beerId) {
        BeerEntity beerEntity = beerRepository.findBeerEntityByBeerId(beerId);
        return convertBeer(beerEntity);
    }

    @Override
    public ArrayList<Beer> getAllBeersByCategory(Integer categoryId) {
        List<BeerEntity> beerEntitiesList = beerRepository.findBeerEntitiesByCategoryEntityCategoryId(categoryId);

        ArrayList<Beer> beers = new ArrayList<>();

        for (BeerEntity beerEntity : beerEntitiesList)
            beers.add(convertBeer(beerEntity));

        return beers;
    }


    private Beer convertBeer(BeerEntity beerEntity){
        Beer beer = providerConverter.beerEntityToBeerModel(beerEntity);
        beer.setCategory(providerConverter.categoryEntityToCategoryModel(beerEntity.getCategoryEntity()));
        return beer;
    }
}
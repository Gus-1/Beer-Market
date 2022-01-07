package com.spring.henallux.beerMarket.dataAccess.dao;

import com.spring.henallux.beerMarket.dataAccess.entity.DiscountEntity;
import com.spring.henallux.beerMarket.dataAccess.repository.DiscountRepository;
import com.spring.henallux.beerMarket.dataAccess.util.ProviderConverter;
import com.spring.henallux.beerMarket.model.Discount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DiscountDAO implements DiscountDataAccess{

    private DiscountRepository discountRepository;

    private ProviderConverter providerConverter;

    @Autowired
    public DiscountDAO(DiscountRepository discountRepository, ProviderConverter providerConverter) {
        this.discountRepository = discountRepository;
        this.providerConverter = providerConverter;
    }

    public Discount getDiscountByCode(String code){
        DiscountEntity discountEntity = discountRepository.findDiscountEntityByCode(code);
        if(discountEntity != null)
            return providerConverter.discountEntityToDiscountModel(discountEntity);
        return null;
    }
}

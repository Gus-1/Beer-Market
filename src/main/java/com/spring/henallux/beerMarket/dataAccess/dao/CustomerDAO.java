package com.spring.henallux.beerMarket.dataAccess.dao;

import com.spring.henallux.beerMarket.dataAccess.repository.CustomerRepository;
import com.spring.henallux.beerMarket.dataAccess.util.ProviderConverter;
import com.spring.henallux.beerMarket.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CustomerDAO implements CustomerDataAccess {

    private CustomerRepository repository;
    private ProviderConverter converter;

    @Autowired
    public CustomerDAO(CustomerRepository repository, ProviderConverter converter){
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public Customer save(Customer customer) {
        return converter.customerEntityToCustomerModel(repository.save(converter.customerModelToCustomerEntity(customer)));
    }
}

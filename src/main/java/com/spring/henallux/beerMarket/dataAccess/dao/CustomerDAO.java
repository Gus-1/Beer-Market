package com.spring.henallux.beerMarket.dataAccess.dao;

import com.spring.henallux.beerMarket.dataAccess.entity.CustomerEntity;
import com.spring.henallux.beerMarket.dataAccess.repository.CustomerRepository;
import com.spring.henallux.beerMarket.dataAccess.util.ProviderConverter;
import com.spring.henallux.beerMarket.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CustomerDAO implements CustomerDataAccess {

    private CustomerRepository customerRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public CustomerDAO(CustomerRepository repository, ProviderConverter providerConverter){
        this.customerRepository = repository;
        this.providerConverter = providerConverter;
    }

    @Transactional
    public Customer save(Customer customer) {
        return providerConverter.customerEntityToCustomerModel(customerRepository.save(providerConverter.customerModelToCustomerEntity(customer)));
    }

    public Customer findCustomerByEmail(String email){
        CustomerEntity customerEntity = customerRepository.findCustomerEntityByEmail(email);
        return providerConverter.customerEntityToCustomerModel(customerEntity);
    }
}

package com.spring.henallux.beerMarket.dataAccess.repository;

import com.spring.henallux.beerMarket.dataAccess.entity.CustomerEntity;
import com.spring.henallux.beerMarket.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {

}

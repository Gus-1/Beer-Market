package com.spring.henallux.beerMarket.dataAccess.repository;

import com.spring.henallux.beerMarket.dataAccess.entity.BeerEntity;
import com.spring.henallux.beerMarket.dataAccess.entity.OrderEntity;
import com.spring.henallux.beerMarket.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Order> {
    BeerEntity findBeerEntityById(Integer beerId);
}
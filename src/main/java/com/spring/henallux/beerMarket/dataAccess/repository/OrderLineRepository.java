package com.spring.henallux.beerMarket.dataAccess.repository;

import com.spring.henallux.beerMarket.dataAccess.entity.OrderLineEntity;
import com.spring.henallux.beerMarket.model.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLineEntity, OrderLine> {

}

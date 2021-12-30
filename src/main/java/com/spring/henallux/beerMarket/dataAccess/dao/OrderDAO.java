package com.spring.henallux.beerMarket.dataAccess.dao;

import com.spring.henallux.beerMarket.dataAccess.entity.OrderEntity;
import com.spring.henallux.beerMarket.dataAccess.repository.OrderLineRepository;
import com.spring.henallux.beerMarket.dataAccess.repository.OrderRepository;
import com.spring.henallux.beerMarket.dataAccess.util.ProviderConverter;
import com.spring.henallux.beerMarket.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrderDAO implements OrderDataAccess{
    private OrderRepository orderRepository;
    private OrderLineRepository orderLineRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public OrderDAO(OrderRepository orderRepository, OrderLineRepository orderLineRepository, ProviderConverter converter){
        this.orderLineRepository = orderLineRepository;
        this.orderRepository = orderRepository;
        this.providerConverter = converter;
    }

    @Transactional
    @Override
    public Order save(Order order){
        OrderEntity orderEntity = providerConverter.orderModelToOrderEntity(order);

        orderEntity = orderRepository.save(orderEntity);
        orderLineRepository.saveAll(orderEntity.getOrderLineEntities());

        return providerConverter.orderEntityToOrderModel(orderEntity);
    }
}

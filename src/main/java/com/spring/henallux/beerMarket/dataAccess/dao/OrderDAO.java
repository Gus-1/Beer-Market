package com.spring.henallux.beerMarket.dataAccess.dao;

import com.spring.henallux.beerMarket.dataAccess.entity.OrderEntity;
import com.spring.henallux.beerMarket.dataAccess.entity.OrderLineEntity;
import com.spring.henallux.beerMarket.dataAccess.entity.OrderLineId;
import com.spring.henallux.beerMarket.dataAccess.repository.OrderLineRepository;
import com.spring.henallux.beerMarket.dataAccess.repository.OrderRepository;
import com.spring.henallux.beerMarket.dataAccess.util.ProviderConverter;
import com.spring.henallux.beerMarket.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.GregorianCalendar;

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
        orderEntity = orderRepository.save(orderEntity);   //todo : ça crash sur cette ligne.

        for (int iEntity = 0; iEntity < orderEntity.getOrderLineEntities().size(); iEntity++) {
            orderEntity
                    .getOrderLineEntities()
                    .get(iEntity)
                    .setOrderLineId(
                            new OrderLineId(
                                    orderEntity,
                                    providerConverter
                                            .beerModelToBeerEntity(
                                                    order
                                                            .getOrderLines()
                                                            .get(iEntity)
                                                            .getBeer()
                                            )
                            )
                    );

            orderEntity
                    .getOrderLineEntities()
                    .get(iEntity)
                    .setOrderLineNumber(iEntity);
        }

        orderLineRepository.saveAll(orderEntity.getOrderLineEntities());

        return providerConverter.orderEntityToOrderModel(orderEntity);
    }
}

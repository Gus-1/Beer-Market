package com.spring.henallux.beerMarket.dataAccess.util;

import com.spring.henallux.beerMarket.dataAccess.entity.*;
import com.spring.henallux.beerMarket.model.*;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
public class ProviderConverter {

    DozerBeanMapper mapper = new DozerBeanMapper();

    public Customer customerEntityToCustomerModel(CustomerEntity customerEntity){
        Customer customer = mapper.map(customerEntity, Customer.class);

        customer.setAccountNonExpired(customerEntity.getAccountNonExpired());
        customer.setAccountNonLocked(customerEntity.getAccountNonLocked());
        customer.setCredentialsNonExpired(customerEntity.getCredentialsNonExpired());
        customer.setEnabled(customerEntity.getEnabled());
        customer.setAuthorities(customerEntity.getAuthorities());
        return customer;
    }

    public CustomerEntity customerModelToCustomerEntity(Customer customer){
        CustomerEntity customerEntity = mapper.map(customer, CustomerEntity.class);
        return customerEntity;
    }

    public Beer beerEntityToBeerModel(BeerEntity beerEntity){
        return mapper.map(beerEntity, Beer.class);
    }

    public Category categoryEntityToCategoryModel(CategoryEntity categoryEntity){
        return mapper.map(categoryEntity, Category.class);
    }

    public OrderEntity orderModelToOrderEntity(Order order){
        OrderEntity orderEntity = mapper.map(order, OrderEntity.class);

        orderEntity.setOrderLineEntities(order.getOrderLines().stream()
                .map(orderLine -> {
                    OrderLineEntity orderLineEntity = new OrderLineEntity();
                    BeerEntity beerEntity = mapper.map(orderLine.getBeer(), BeerEntity.class);

                    orderLineEntity.setOrderId(orderEntity);
                    orderLineEntity.setBeerId(beerEntity);
                    orderLineEntity.setPrice(beerEntity.getPrice());
                    orderLineEntity.setQuantity(orderLine.getQuantity());

                    return orderLineEntity;
                }).collect(Collectors.toCollection(ArrayList::new)));

        return orderEntity;
    }

    public Order orderEntityToOrderModel(OrderEntity orderEntity){
        return mapper.map(orderEntity, Order.class);
    }


    public CategoryTranslation translationCategoryEntityToCategoryTranslation(TranslationCategoryEntity translationCategoryEntity){
        CategoryTranslation categoryTranslation = new CategoryTranslation();

        categoryTranslation.setLabel(translationCategoryEntity.getLabel());
        categoryTranslation.setCategoryId(translationCategoryEntity.getTranslationCategoryId().getCategoryId().getCategoryId());

        return categoryTranslation;
    }
}

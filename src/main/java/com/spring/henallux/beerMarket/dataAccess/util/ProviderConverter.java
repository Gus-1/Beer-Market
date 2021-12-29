package com.spring.henallux.beerMarket.dataAccess.util;

import com.spring.henallux.beerMarket.dataAccess.entity.BeerEntity;
import com.spring.henallux.beerMarket.dataAccess.entity.CategoryEntity;
import com.spring.henallux.beerMarket.dataAccess.entity.CustomerEntity;
import com.spring.henallux.beerMarket.model.Beer;
import com.spring.henallux.beerMarket.model.Category;
import com.spring.henallux.beerMarket.model.Customer;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

@Component
public class ProviderConverter {

    DozerBeanMapper mapper = new DozerBeanMapper();
/*
    public UserEntityToDELETE userModelToUserEntity(UserToDELETE userToDELETE) {
        UserEntityToDELETE userEntityToDELETE = new UserEntityToDELETE();
        mapper.map(userToDELETE, userEntityToDELETE);
        return userEntityToDELETE;
    }

    public UserToDELETE userEntityToUserModel(UserEntityToDELETE userEntityToDELETE) {
        UserToDELETE userToDELETE = new UserToDELETE();
        mapper.map(userEntityToDELETE, userToDELETE);
        return userToDELETE;
    }*/

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
}

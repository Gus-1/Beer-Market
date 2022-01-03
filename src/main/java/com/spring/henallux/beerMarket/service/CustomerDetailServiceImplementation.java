package com.spring.henallux.beerMarket.service;

import com.spring.henallux.beerMarket.dataAccess.dao.CustomerDataAccess;
import com.spring.henallux.beerMarket.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomerDetailServiceImplementation implements UserDetailsService {
    private CustomerDataAccess customerDataAccess;

    @Autowired
    public CustomerDetailServiceImplementation(CustomerDataAccess customerDataAccess){
        this.customerDataAccess = customerDataAccess;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Customer customer = customerDataAccess.findCustomerByEmail(s);
        if (customer != null)
            return customer;
        throw new UsernameNotFoundException("Customer not found");
    }
}

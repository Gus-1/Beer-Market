package com.spring.henallux.beerMarket.dataAccess.dao;

import com.spring.henallux.beerMarket.model.UserToDELETE;

public interface UserDataAccess {

    UserToDELETE save(UserToDELETE userToDELETE);
}

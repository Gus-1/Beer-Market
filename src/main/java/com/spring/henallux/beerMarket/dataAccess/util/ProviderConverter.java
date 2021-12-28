package com.spring.henallux.beerMarket.dataAccess.util;

import com.spring.henallux.beerMarket.dataAccess.entity.UserEntityToDELETE;
import com.spring.henallux.beerMarket.model.UserToDELETE;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

@Component
public class ProviderConverter {

    DozerBeanMapper mapper;

    public UserEntityToDELETE userModelToUserEntity(UserToDELETE userToDELETE) {
        UserEntityToDELETE userEntityToDELETE = new UserEntityToDELETE();
        mapper.map(userToDELETE, userEntityToDELETE);
        return userEntityToDELETE;
    }

    public UserToDELETE userEntityToUserModel(UserEntityToDELETE userEntityToDELETE) {
        UserToDELETE userToDELETE = new UserToDELETE();
        mapper.map(userEntityToDELETE, userToDELETE);
        return userToDELETE;
    }
}

package com.spring.henallux.beerMarket.dataAccess.dao;

import com.spring.henallux.beerMarket.dataAccess.repository.UserRepository;
import com.spring.henallux.beerMarket.dataAccess.util.ProviderConverter;
import com.spring.henallux.beerMarket.model.UserToDELETE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserDAO implements UserDataAccess {

    private UserRepository userRepository;
    private ProviderConverter providerConverter;


    @Autowired
    public UserDAO(UserRepository userRepository, ProviderConverter providerConverter) {
        this.userRepository = userRepository;
    }

    @Override
    public UserToDELETE save(UserToDELETE userToDELETE) {
        return providerConverter.userEntityToUserModel(userRepository.save(providerConverter.userModelToUserEntity(userToDELETE)));     //todo : Décomposer, ç'est imbitable
    }
}

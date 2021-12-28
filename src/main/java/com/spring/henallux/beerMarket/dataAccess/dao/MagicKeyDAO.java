package com.spring.henallux.beerMarket.dataAccess.dao;

import com.spring.henallux.beerMarket.dataAccess.entity.MagicKeyEntityToDELETE;
import com.spring.henallux.beerMarket.dataAccess.repository.MagicKeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MagicKeyDAO implements MagicKeyDataAccess{

    private MagicKeyRepository magicKeyRepository;

    @Autowired
    public MagicKeyDAO(MagicKeyRepository magicKeyRepository){
        this.magicKeyRepository = magicKeyRepository;
    }

    public ArrayList<String> getMagicKeys(){
        List<MagicKeyEntityToDELETE> magicKeyEntities = magicKeyRepository.findAll();
        ArrayList<String> arrayList = new ArrayList<>();
        for (MagicKeyEntityToDELETE magicKey : magicKeyEntities){
            arrayList.add(magicKey.getMagicKeyValue());
        }
        return arrayList;
    }
}

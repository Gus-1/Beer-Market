package com.spring.henallux.beerMarket.dataAccess.repository;

import com.spring.henallux.beerMarket.dataAccess.entity.MagicKeyEntityToDELETE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MagicKeyRepository extends JpaRepository<MagicKeyEntityToDELETE, String> {

}

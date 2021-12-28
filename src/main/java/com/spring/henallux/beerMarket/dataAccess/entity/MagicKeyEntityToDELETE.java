package com.spring.henallux.beerMarket.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="magickey")
public class MagicKeyEntityToDELETE {
    @Id
    @Column(name = "magicvalue")
    private String magicKeyValue;

    public MagicKeyEntityToDELETE() {
    }

    public String getMagicKeyValue() {
        return magicKeyValue;
    }
    public void setMagicKeyValue(String magicKeyValue) {
        this.magicKeyValue = magicKeyValue;
    }
}

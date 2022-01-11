package com.spring.henallux.beerMarket.model.exception;

public class DiscountException extends Exception{

    private String exceptionMessage;

    public DiscountException(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    @Override
    public String getMessage(){
        return exceptionMessage;
    }
}

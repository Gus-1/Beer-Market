package com.spring.henallux.beerMarket.service;

import com.spring.henallux.beerMarket.dataAccess.dao.DiscountDataAccess;
import com.spring.henallux.beerMarket.model.Discount;
import com.spring.henallux.beerMarket.model.OrderLine;

import java.util.HashMap;

public class DiscountService {


    public static Boolean checkEligibility(HashMap<Integer, OrderLine> cart, String code){

        int cpt = 0;
        Boolean isEligible = false;

        switch (code) {
            case "BE10" -> {
                for (OrderLine orderline : cart.values()) {
                    if (orderline.getBeer().getOriginCountry().equals("Belgique")) {
                        cpt++;
                    }
                }
                if (cpt >= 1) isEligible = true;

            }
            case "BLOND15" -> {
                for (OrderLine orderline : cart.values()) {
                    if (orderline.getBeer().getCategory().getCategoryId() == 2) {
                        cpt++;
                    }
                }
                if (cpt >= 2) isEligible = true;

            }
            case "BROWN20" -> {
                for (OrderLine orderline : cart.values()) {
                    if (orderline.getBeer().getCategory().getCategoryId() == 1) {
                        cpt++;
                    }
                }
                if (cpt >= 2) isEligible = true;
            }
        }
        return isEligible;
    }
}
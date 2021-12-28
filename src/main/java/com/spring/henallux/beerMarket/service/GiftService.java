package com.spring.henallux.beerMarket.service;

import org.springframework.stereotype.Service;

@Service
public class GiftService {
    public String chooseGift(String hobby, int age){
        String gift;
        if (hobby.equals("2")){
            if (age < 5){
                gift = "Un puzzle de Nature";
            } else if (age > 10) {
                gift = "Un dvd de Nature";
            } else {
                gift = "Un livre de Nature";
            }
        }
        else if (hobby.equals("3")){
            if (age < 5){
                gift = "Un puzzle de Livres";
            } else if (age > 10) {
                gift = "Un dvd de Livres";
            } else {
                gift = "Un livre de Livres";
            }
        }
        else {
            if (age < 5){
                gift = "Un puzzle de Musique";
            } else if (age > 10) {
                gift = "Un dvd de Musique";
            } else {
                gift = "Un livre de Musique";
            }
        }
        return gift;
    }
}

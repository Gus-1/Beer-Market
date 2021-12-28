package com.spring.henallux.beerMarket.service;

import com.spring.henallux.beerMarket.model.HobbyToDELETE;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class HobbiesService {
    private ArrayList<HobbyToDELETE> hobbiesList;

    public HobbiesService() {
        hobbiesList = new ArrayList<>();
        hobbiesList.add(new HobbyToDELETE("1", "Sport"));
        hobbiesList.add(new HobbyToDELETE("2", "Nature"));
        hobbiesList.add(new HobbyToDELETE("3", "Reading"));
        hobbiesList.add(new HobbyToDELETE("4", "Music"));
    }

    public ArrayList<HobbyToDELETE> getHobbiesList() {
        return hobbiesList;
    }

    public void setHobbiesList(ArrayList<HobbyToDELETE> hobbiesList) {
        this.hobbiesList = hobbiesList;
    }
}

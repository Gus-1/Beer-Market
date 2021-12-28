package com.spring.henallux.beerMarket.controller;

import com.spring.henallux.beerMarket.Constants;
import com.spring.henallux.beerMarket.model.UserToDELETE;
import com.spring.henallux.beerMarket.service.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "/gift")
@SessionAttributes({Constants.CURRENT_USER})
public class GiftController {
    private GiftService giftService;

    @RequestMapping(method = RequestMethod.GET)
    public String home (Model model, @ModelAttribute(value= Constants.CURRENT_USER) UserToDELETE userToDELETE){
        model.addAttribute("hobbies", giftService.chooseGift(userToDELETE.getHobby(), userToDELETE.getAge()));
        System.out.println(userToDELETE.getHobby());
        return "integrated:gift";
    }

    @Autowired
    public GiftController(GiftService giftService){
        this.giftService = giftService;
    }
}

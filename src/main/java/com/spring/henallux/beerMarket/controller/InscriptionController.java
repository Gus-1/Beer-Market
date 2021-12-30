package com.spring.henallux.beerMarket.controller;


import com.spring.henallux.beerMarket.service.HobbiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value="/inscription")
//@SessionAttributes({Constants.CURRENT_USER})
public class InscriptionController {
    /*private HobbiesService hobbiesService;

    @ModelAttribute(Constants.CURRENT_USER)
    public UserToDELETE user(){
        return new UserToDELETE();
    }

    @Autowired
    public InscriptionController(HobbiesService hobbiesService) {
        this.hobbiesService = hobbiesService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home (Model model){
        model.addAttribute("hobbies", hobbiesService.getHobbiesList());
        model.addAttribute("user",new UserToDELETE());
        return "integrated:userInscription";
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String getFormData(Model model, @ModelAttribute(value=Constants.CURRENT_USER) UserToDELETE userToDELETE, final BindingResult errors) {
        return "redirect:/gift";
    }*/
}

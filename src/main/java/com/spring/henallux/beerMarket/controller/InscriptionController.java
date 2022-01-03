package com.spring.henallux.beerMarket.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

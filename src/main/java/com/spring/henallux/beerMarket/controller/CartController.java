package com.spring.henallux.beerMarket.controller;

import com.spring.henallux.beerMarket.dataAccess.dao.BeerDataAccess;
import com.spring.henallux.beerMarket.dataAccess.dao.CategoryDataAccess;
import com.spring.henallux.beerMarket.dataAccess.dao.DiscountDataAccess;
import com.spring.henallux.beerMarket.model.*;
import com.spring.henallux.beerMarket.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@Controller
@RequestMapping(value = "/cart")
@SessionAttributes({Constants.CURRENT_CART, Constants.CURRENT_DISCOUNT})
public class CartController extends SuperController {
    private BeerDataAccess beerDataAccess;
    private DiscountDataAccess discountDataAccess;

    @ModelAttribute(Constants.CURRENT_CART)
    public HashMap<Integer, OrderLine> cart() {
        return new HashMap<>();
    }
    @ModelAttribute(Constants.CURRENT_DISCOUNT)
    public Discount currentDiscount(){
        return new Discount();
    }

    @Autowired
    public CartController(CategoryDataAccess categoryDataAccess, BeerDataAccess beerDataAccess, DiscountDataAccess discountDataAccess){
        super(categoryDataAccess);
        this.beerDataAccess = beerDataAccess;
        this.discountDataAccess = discountDataAccess;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getCart(Model model,
                          @ModelAttribute(value = Constants.CURRENT_CART) HashMap<Integer, OrderLine> cart,
                          @ModelAttribute(value = Constants.CURRENT_DISCOUNT) Discount currentDiscount){

        model.addAttribute("customer", new Customer());
        model.addAttribute("title", "Cart Details");

        model.addAttribute("categories", getAllCategories());
        model.addAttribute("orderLine", new OrderLine());


        if(!model.containsAttribute("cart")){
            model.addAttribute("cart", new HashMap<Integer, OrderLine>());
        }
        if(!model.containsAttribute("currentDiscount")){
            model.addAttribute("currentDiscount", new Discount());
        }

        return "integrated:cart";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add/{id}")
    public String addToCart(@ModelAttribute(value = Constants.CURRENT_CART) HashMap<Integer, OrderLine> cart,
                            @ModelAttribute(value = Constants.CURRENT_DISCOUNT) Discount currentDiscount,
                            @PathVariable(value = "id") Integer id,
                            @Valid @ModelAttribute(value = "orderLine") OrderLine orderLine,
                            final BindingResult errors){

        currentDiscount.setReduction(null);
        currentDiscount.setDiscountId(null);
        currentDiscount.setCode(null);

        if(!errors.hasErrors()){
            if(cart.containsKey(id)){
                cart.get(id).setQuantity(cart.get(id).getQuantity() + orderLine.getQuantity());
            } else {
                Beer beer = beerDataAccess.getBeerById(id);

                orderLine.setBeer(beer);
                cart.put(id, orderLine);
            }
            return "redirect:/cart";
        }
        return "redirect:/details/" + id;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update/{id}")
    public String updateCart(@ModelAttribute(value = Constants.CURRENT_CART)HashMap<Integer, OrderLine> cart,
                             @ModelAttribute(value = Constants.CURRENT_DISCOUNT) Discount currentDiscount,
                             @PathVariable(value = "id") Integer id,
                             @Valid @ModelAttribute(value = "orderLine") OrderLine orderLine,
                             final BindingResult errors){

        currentDiscount.setReduction(null);
        currentDiscount.setDiscountId(null);
        currentDiscount.setCode(null);

        if(!errors.hasErrors()){
            if(orderLine.getQuantity() > 0){
                cart.get(id).setQuantity(orderLine.getQuantity());
            } else {
                cart.remove(id);
            }
            return "redirect:/cart";
        }
        return "integrated:/details/" + id;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/discount")
    public String addDiscount(@ModelAttribute(value = Constants.CURRENT_CART) HashMap<Integer, OrderLine> cart,
                              @ModelAttribute (value = Constants.CURRENT_DISCOUNT) Discount currentDiscount,
                              @Valid @ModelAttribute(value = "currentDiscount") Discount discount,
                              final BindingResult errors){

        if(!errors.hasErrors()){
            Discount checkDiscount = discountDataAccess.getDiscountByCode(discount.getCode());
            if (checkDiscount != null){
                if(DiscountService.checkEligibility(cart,discount.getCode())){
                    currentDiscount.setReduction(checkDiscount.getReduction());
                    currentDiscount.setCode(checkDiscount.getCode());
                }
                else{
                    currentDiscount.setReduction(null);
                    currentDiscount.setDiscountId(null);
                    currentDiscount.setCode(null);
                }
            }else {
                currentDiscount.setReduction(null);
                currentDiscount.setDiscountId(null);
                currentDiscount.setCode(null);
            }
        }
        return "redirect:/cart";
    }
}


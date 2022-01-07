package com.spring.henallux.beerMarket.controller;

import com.spring.henallux.beerMarket.dataAccess.dao.BeerDataAccess;
import com.spring.henallux.beerMarket.dataAccess.dao.CategoryDataAccess;
import com.spring.henallux.beerMarket.dataAccess.dao.DiscountDataAccess;
import com.spring.henallux.beerMarket.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@Controller
@RequestMapping(value = "/cart")
@SessionAttributes({Constants.CURRENT_CART})
public class CartController extends SuperController {
    private BeerDataAccess beerDataAccess;
    private DiscountDataAccess discountDataAccess;

    @ModelAttribute(Constants.CURRENT_CART)
    public HashMap<Integer, OrderLine> cart() {
        return new HashMap<>();
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
                          @ModelAttribute(value="code") Discount discount){
        if(!model.containsAttribute("code")){
            model.addAttribute("code", new Discount());
        }
        Discount checkDiscount = discountDataAccess.getDiscountByCode(discount.getCode());
        if (checkDiscount != null){
            //Check cart
            model.addAttribute("discount", checkDiscount.getReduction());
        }else {
            model.addAttribute("discount", 0);
        }

        model.addAttribute("customer", new Customer());

        model.addAttribute("categories", getAllCategories());
        model.addAttribute("title", "Cart Details");
        model.addAttribute("orderLine", new OrderLine());


        if(!model.containsAttribute("cart")){
            model.addAttribute("cart", new HashMap<Integer, OrderLine>());
        }
        return "integrated:cart";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add/{id}")
    public String addToCart(@ModelAttribute(value = Constants.CURRENT_CART) HashMap<Integer, OrderLine> cart,
                            @PathVariable(value = "id") Integer id,
                            @Valid @ModelAttribute(value = "orderLine") OrderLine orderLine,
                            final BindingResult errors){
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
                             @PathVariable(value = "id") Integer id,
                             @Valid @ModelAttribute(value = "orderLine") OrderLine orderLine,
                             final BindingResult errors){
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

    @RequestMapping(method = RequestMethod.POST, value = "/applyDiscount")
    public String applyDiscount(Model model, @ModelAttribute(value = Constants.CURRENT_CART)HashMap<Integer, OrderLine> cart,
                                @Valid @ModelAttribute(value = "code") Discount discountCode,
                                final BindingResult errors){
        Discount discount = discountDataAccess.getDiscountByCode(discountCode.getCode());
        if (discount != null)
            model.addAttribute("discount", discount.getReduction());
            model.addAttribute("code", discount);
            //Apply the discount
        return "redirect:/cart";
    }
}


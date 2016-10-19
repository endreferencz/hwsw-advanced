package com.epam.bookshop.shopping.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.epam.bookshop.shopping.view.model.ShoppingCart;
import com.epam.bookshop.shopping.view.model.ShowShoppingCartModel;

@Controller
@SessionAttributes(value = ShoppingCart.SHOPPING_CART_KEY)
public class ShowShoppingCartController {
	public static final String REQUEST_MAPPING = "/showShoppingCart.html";

	@ModelAttribute("shoppingCartModel")
	public ShowShoppingCartModel createShoppingCartModel(@ModelAttribute(ShoppingCart.SHOPPING_CART_KEY) ShoppingCart shoppingCart) {
		return new ShowShoppingCartModel(shoppingCart.getItems(), ClearShoppingCartController.REQUEST_MAPPING);
	}

	@RequestMapping(value = REQUEST_MAPPING, method = RequestMethod.GET)
	public String addToCart() {
		return "shopping_cart";
	}
}

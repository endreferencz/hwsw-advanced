package com.epam.bookshop.shopping.view.model;

import java.util.List;

public class ShowShoppingCartModel {
	private List<BookShoppingCartItem> cartItems;
	private String clearShoppingCartUrl;

	public ShowShoppingCartModel(List<BookShoppingCartItem> cartItems, String clearShoppingCartUrl) {
		super();
		this.cartItems = cartItems;
		this.clearShoppingCartUrl = clearShoppingCartUrl;
	}

	public List<BookShoppingCartItem> getCartItems() {
		return cartItems;
	}

	public String getClearShoppingCartUrl() {
		return clearShoppingCartUrl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cartItems == null) ? 0 : cartItems.hashCode());
		result = prime * result + ((clearShoppingCartUrl == null) ? 0 : clearShoppingCartUrl.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShowShoppingCartModel other = (ShowShoppingCartModel) obj;
		if (cartItems == null) {
			if (other.cartItems != null)
				return false;
		} else if (!cartItems.equals(other.cartItems))
			return false;
		if (clearShoppingCartUrl == null) {
			if (other.clearShoppingCartUrl != null)
				return false;
		} else if (!clearShoppingCartUrl.equals(other.clearShoppingCartUrl))
			return false;
		return true;
	}

}

package com.epam.bookshop.shopping.view.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {
	public static final String SHOPPING_CART_KEY = "SHOPPING_CART";
	private Map<Long, BookShoppingCartItem> items;

	public ShoppingCart() {
		super();
		this.items = new HashMap<Long, BookShoppingCartItem>();
	}

	public List<BookShoppingCartItem> getItems() {
		return new ArrayList<BookShoppingCartItem>(items.values());
	}

	public void clear() {
		items.clear();
	}

	public void addBook(BookShoppingCartItem item) {
		BookShoppingCartItem bookShoppingCartItem = items.get(item.getBookId());
		Integer quantity;
		if (bookShoppingCartItem == null) {
			quantity = 1;
		} else {
			quantity = bookShoppingCartItem.getQuantity() + 1;
		}
		items.put(item.getBookId(), new BookShoppingCartItem(item.getBook(), quantity));
	}

}

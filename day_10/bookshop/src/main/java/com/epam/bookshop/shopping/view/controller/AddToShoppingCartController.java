package com.epam.bookshop.shopping.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.epam.bookshop.book.domain.Book;
import com.epam.bookshop.book.service.BookSearchService;
import com.epam.bookshop.shopping.view.model.AddShoppingCartBookItemRequest;
import com.epam.bookshop.shopping.view.model.BookShoppingCartItem;
import com.epam.bookshop.shopping.view.model.BookSummaryView;
import com.epam.bookshop.shopping.view.model.ShoppingCart;
import com.epam.bookshop.shopping.view.transform.BookTransformer;

@Controller
@SessionAttributes(value = ShoppingCart.SHOPPING_CART_KEY)
public class AddToShoppingCartController {
    public static final String REQUEST_MAPPING = "/addToCart.html";
    private BookSearchService bookSearchService;
    private BookTransformer bookTransformer;

    @Autowired
    public AddToShoppingCartController(BookSearchService bookSearchService, BookTransformer bookTransformer) {
        super();
        this.bookSearchService = bookSearchService;
        this.bookTransformer = bookTransformer;
    }

    @ModelAttribute
    public ShoppingCart ShoppingCart(@ModelAttribute(ShoppingCart.SHOPPING_CART_KEY) ShoppingCart shoppingCart) {
        ShoppingCart result;
        if (shoppingCart == null) {
            result = new ShoppingCart();
        } else {
            result = shoppingCart;
        }
        return result;
    }

    @RequestMapping(value = REQUEST_MAPPING, method = RequestMethod.POST)
    public String addToCart(AddShoppingCartBookItemRequest addShoppingCartBookItemRequest,
            @ModelAttribute(ShoppingCart.SHOPPING_CART_KEY) ShoppingCart shoppingCart) {
        Book book = findBook(addShoppingCartBookItemRequest);
        BookSummaryView bookSummary = transformBook(book);
        doAddToCart(shoppingCart, createShoppingCartItem(bookSummary));
        return redirectToBookList();
    }

    private String redirectToBookList() {
        return String.format("redirect:%s", ListBooksController.REQUEST_MAPPING);
    }

    private void doAddToCart(ShoppingCart shoppingCart, BookShoppingCartItem createShoppingCartItem) {
        shoppingCart.addBook(createShoppingCartItem);
    }

    private BookShoppingCartItem createShoppingCartItem(BookSummaryView bookSummary) {
        return new BookShoppingCartItem(bookSummary, 1);
    }

    private BookSummaryView transformBook(Book book) {
        BookSummaryView bookSummary = bookTransformer.transformBookToSummary(book);
        return bookSummary;
    }

    private Book findBook(AddShoppingCartBookItemRequest addShoppingCartBookItemRequest) {
        Book book = bookSearchService.findBook(addShoppingCartBookItemRequest.getBookId());
        return book;
    }

}

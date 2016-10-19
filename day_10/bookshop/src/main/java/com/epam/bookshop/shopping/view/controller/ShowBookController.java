package com.epam.bookshop.shopping.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.bookshop.book.domain.Book;
import com.epam.bookshop.book.service.BookSearchService;
import com.epam.bookshop.shopping.view.model.AddShoppingCartBookItemRequest;
import com.epam.bookshop.shopping.view.model.BookDetailsModel;
import com.epam.bookshop.shopping.view.model.BookDetailsView;
import com.epam.bookshop.shopping.view.model.BookSummaryView;
import com.epam.bookshop.shopping.view.model.ShowBookRequest;
import com.epam.bookshop.shopping.view.transform.BookTransformer;

@Controller
public class ShowBookController {
    public static final String REQUEST_MAPPING = "/showBook.html";
    private BookSearchService bookSearchService;
    private BookTransformer bookTransformer;

    @Autowired
    public ShowBookController(BookSearchService bookSearchService, BookTransformer bookTransformer) {
        super();
        this.bookSearchService = bookSearchService;
        this.bookTransformer = bookTransformer;
    }

    @ModelAttribute("bookDetailsModel")
    public BookDetailsModel createBookDetailsModel(ShowBookRequest showBookRequest) {
        Book book = findBook(showBookRequest.getBookId());
        return initBookDetailsModel(book);
    }

    @ModelAttribute("addShoppingCartBookItemRequest")
    public AddShoppingCartBookItemRequest createAddShoppingCartBookItemRequest(ShowBookRequest showBookRequest) {
        AddShoppingCartBookItemRequest result = new AddShoppingCartBookItemRequest();
        result.setBookId(showBookRequest.getBookId());
        return result;
    }

    @RequestMapping(REQUEST_MAPPING)
    public String showBooks() {
        return "book_details";
    }

    private BookDetailsModel initBookDetailsModel(Book book) {
        BookSummaryView summary = bookTransformer.transformBookToSummary(book);
        BookDetailsView details = bookTransformer.transformBookToDetails(book);
        return new BookDetailsModel(summary, details, AddToShoppingCartController.REQUEST_MAPPING);
    }

    private Book findBook(Long bookId) {
        return bookSearchService.findBook(bookId);
    }

}

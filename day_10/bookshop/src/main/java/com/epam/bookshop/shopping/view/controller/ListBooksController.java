package com.epam.bookshop.shopping.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.bookshop.book.domain.Book;
import com.epam.bookshop.book.service.BookSearchService;
import com.epam.bookshop.shopping.view.model.BookSummaryView;
import com.epam.bookshop.shopping.view.model.ListBooksModel;
import com.epam.bookshop.shopping.view.model.ListBooksRequest;
import com.epam.bookshop.shopping.view.transform.BookTransformer;

@Controller
public class ListBooksController {
    public static final String REQUEST_MAPPING = "/shopping.html";
    private BookSearchService bookSearchService;
    private BookTransformer bookTransformer;

    @Autowired
    public ListBooksController(BookSearchService bookSearchService, BookTransformer bookTransformer) {
        super();
        this.bookSearchService = bookSearchService;
        this.bookTransformer = bookTransformer;
    }

    @ModelAttribute("listBooksModel")
    public ListBooksModel createListBooksModel(ListBooksRequest listBooksRequest) {
        List<Book> books = listBooks(listBooksRequest);
        List<BookSummaryView> bookViews = transformBooks(books);
        return initListBooksModel(bookViews);
    }

    @RequestMapping(value = REQUEST_MAPPING, method = RequestMethod.GET)
    public String showBooks() {
        return "shopping";
    }

    private List<BookSummaryView> transformBooks(List<Book> books) {
        return bookTransformer.transformBooksToSummaries(books);
    }

    private ListBooksModel initListBooksModel(List<BookSummaryView> bookViews) {
        return new ListBooksModel(bookViews);
    }

    private List<Book> listBooks(ListBooksRequest searchBooksRequest) {
        return bookSearchService.listBooks(searchBooksRequest.getTitle());
    }

}

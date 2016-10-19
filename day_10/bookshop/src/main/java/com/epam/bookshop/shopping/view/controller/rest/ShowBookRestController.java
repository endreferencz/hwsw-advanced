package com.epam.bookshop.shopping.view.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.bookshop.book.service.BookSearchService;
import com.epam.bookshop.shopping.view.model.BookSummaryView;
import com.epam.bookshop.shopping.view.transform.BookTransformer;

@RestController
@RequestMapping("/rest-api")
public class ShowBookRestController {
    private BookSearchService bookSearchService;
    private BookTransformer bookTransformer;

    @Autowired
    public ShowBookRestController(BookSearchService bookSearchService, BookTransformer bookTransformer) {
        super();
        this.bookSearchService = bookSearchService;
        this.bookTransformer = bookTransformer;
    }

    @RequestMapping("books/{bookId}")
    public BookSummaryView getBook(@PathVariable Long bookId) {
        return bookTransformer.transformBookToSummary(bookSearchService.findBook(bookId));
    }
}

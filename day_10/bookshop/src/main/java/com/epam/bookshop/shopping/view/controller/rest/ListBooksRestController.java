package com.epam.bookshop.shopping.view.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.bookshop.book.service.BookSearchService;
import com.epam.bookshop.shopping.view.model.BookSummaryView;
import com.epam.bookshop.shopping.view.transform.BookTransformer;

@RestController
@RequestMapping("/rest-api")
public class ListBooksRestController {
    private BookSearchService bookSearchService;
    private BookTransformer bookTransformer;

    @Autowired
    public ListBooksRestController(BookSearchService bookSearchService, BookTransformer bookTransformer) {
        super();
        this.bookSearchService = bookSearchService;
        this.bookTransformer = bookTransformer;
    }

    @RequestMapping("books")
    public List<BookSummaryView> clients() {
        return bookTransformer.transformBooksToSummaries(bookSearchService.listAllBooks());
    }
}

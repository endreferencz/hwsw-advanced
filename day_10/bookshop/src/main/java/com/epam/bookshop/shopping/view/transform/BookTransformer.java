package com.epam.bookshop.shopping.view.transform;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import com.epam.bookshop.book.domain.Book;
import com.epam.bookshop.shopping.view.controller.BookCoverImageController;
import com.epam.bookshop.shopping.view.controller.ShowBookController;
import com.epam.bookshop.shopping.view.model.BookDetailsView;
import com.epam.bookshop.shopping.view.model.BookSummaryView;

@Component
public class BookTransformer {
    private static final String BOOK_QUERY_URL_PATTERN = "%s?bookId=%d";

    private ConversionService onversionService;

    @Autowired
    public BookTransformer(ConversionService onversionService) {
        super();
        this.onversionService = onversionService;
    }

    public List<BookSummaryView> transformBooksToSummaries(List<Book> books) {
        List<BookSummaryView> result = new ArrayList<BookSummaryView>();
        for (Book book : books) {
            result.add(transformBookToSummary(book));
        }
        return result;
    }

    public BookSummaryView transformBookToSummary(Book book) {
        BookSummaryView result = new BookSummaryView();
        result.setAuthor(book.getAuthor());
        result.setTitle(book.getTitle());
        result.setBookId(book.getBookId());
        result.setDetailsUrl(String.format(BOOK_QUERY_URL_PATTERN, ShowBookController.REQUEST_MAPPING, book.getBookId()));
        result.setBookFormat(onversionService.convert(book.getFormat(), String.class));
        return result;
    }

    public BookDetailsView transformBookToDetails(Book book) {
        BookDetailsView result = new BookDetailsView();
        result.setSynopsis(book.getSynopsis());
        if (book.getCover() != null) {
            result.setCoverUrl(String.format(BOOK_QUERY_URL_PATTERN, BookCoverImageController.REQUEST_MAPPING, book.getBookId()));
        }
        return result;
    }
}

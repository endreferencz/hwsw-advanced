package com.epam.bookshop.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.bookshop.book.domain.Book;
import com.epam.bookshop.book.repository.dao.BookDao;
import com.epam.bookshop.book.repository.domain.BookEntity;
import com.epam.bookshop.book.service.transform.BookEntityTransformer;

@Service
public class BookSearchService {
    private BookDao bookDao;
    private BookEntityTransformer bookEntityTransformer;

    @Autowired
    public BookSearchService(BookDao bookDao, BookEntityTransformer bookEntityTransformer) {
        super();
        this.bookDao = bookDao;
        this.bookEntityTransformer = bookEntityTransformer;
    }

    public Book findBook(Long bookId) {
        return transformBookEntity(doFindBook(bookId));
    }

    public List<Book> listAllBooks() {
        return transformBookEntities(bookDao.findAll());
    }

    private Book transformBookEntity(BookEntity book) {
        return bookEntityTransformer.transformBookEntity(book);
    }

    private BookEntity doFindBook(Long bookId) {
        return bookDao.findOne(bookId);
    }

    public List<Book> listBooks(String title) {
        return transformBookEntities(findBookEntities(formatQuery(title)));
    }

    private String formatQuery(String title) {
        String result;
        if (title == null) {
            result = "%";
        } else {
            result = String.format("%%%s%%", title);
        }
        return result;
    }

    private List<Book> transformBookEntities(Iterable<BookEntity> books) {
        return bookEntityTransformer.transformBookEntities(books);
    }

    private Iterable<BookEntity> findBookEntities(String title) {
        return bookDao.findByTitleIgnoreCaseLike(title);
    }

}

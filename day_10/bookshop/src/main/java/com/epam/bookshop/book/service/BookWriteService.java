package com.epam.bookshop.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.bookshop.book.domain.Book;
import com.epam.bookshop.book.repository.dao.BookDao;
import com.epam.bookshop.book.service.transform.BookEntityTransformer;

@Service
public class BookWriteService {
	private BookDao bookDao;
	private BookEntityTransformer bookEntityTransformer;

	@Autowired
	public BookWriteService(BookDao bookDao, BookEntityTransformer bookEntityTransformer) {
		super();
		this.bookDao = bookDao;
		this.bookEntityTransformer = bookEntityTransformer;
	}

	public void saveBook(Book book) {
		bookDao.save(bookEntityTransformer.transformBookToBookEntity(book));
	}

}

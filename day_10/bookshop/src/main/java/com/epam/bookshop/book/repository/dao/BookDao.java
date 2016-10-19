package com.epam.bookshop.book.repository.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.epam.bookshop.book.repository.domain.BookEntity;

public interface BookDao extends CrudRepository<BookEntity, Long> {
	List<BookEntity> findByTitleIgnoreCaseLike(String title);
}

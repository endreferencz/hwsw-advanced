package com.epam.bookshop.shopping.view.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.AbstractResource;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.epam.bookshop.book.service.BookSearchService;
import com.epam.bookshop.shopping.view.model.ShowBookRequest;

@Controller
public class BookCoverImageController {
	public static final String REQUEST_MAPPING = "/bookCover.jpg";
	private BookSearchService bookSearchService;

	@Autowired
	public BookCoverImageController(BookSearchService bookSearchService) {
		super();
		this.bookSearchService = bookSearchService;
	}

	@RequestMapping(value = REQUEST_MAPPING, method = RequestMethod.GET)
	@ResponseBody
	public AbstractResource downloadCover(ShowBookRequest showBookRequest, HttpServletResponse httpServletResponse) {
		return new ByteArrayResource(bookSearchService.findBook(showBookRequest.getBookId()).getCover());
	}
}

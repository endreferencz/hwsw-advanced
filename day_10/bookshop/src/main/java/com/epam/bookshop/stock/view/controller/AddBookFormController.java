package com.epam.bookshop.stock.view.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.bookshop.book.domain.BookFormat;
import com.epam.bookshop.stock.view.model.AddBookFormModel;
import com.epam.bookshop.stock.view.model.AddBookRequest;

@Controller
public class AddBookFormController {
	public static final String REQUEST_MAPPING = "/addBookForm.html";

	@ModelAttribute("addBookRequest")
	public AddBookRequest createListBooksModel(@ModelAttribute AddBookRequest addBookRequest) {
		return new AddBookRequest();
	}

	@ModelAttribute("addBookFormModel")
	public AddBookFormModel createListBooksModel() {
		return new AddBookFormModel(Arrays.asList(BookFormat.values()));
	}

	@RequestMapping(value = REQUEST_MAPPING, method = RequestMethod.GET)
	private String createBook() {
		return "add_book";
	}

}

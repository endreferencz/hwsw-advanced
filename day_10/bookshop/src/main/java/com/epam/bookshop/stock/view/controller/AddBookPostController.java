package com.epam.bookshop.stock.view.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.epam.bookshop.book.domain.BookFormat;
import com.epam.bookshop.book.service.BookWriteService;
import com.epam.bookshop.stock.view.model.AddBookFormModel;
import com.epam.bookshop.stock.view.model.AddBookRequest;
import com.epam.bookshop.stock.view.transform.AddBookRequestTransformer;

@Controller
public class AddBookPostController {
	public static final String REQUEST_MAPPING = "/addBookPost.html";
	private BookWriteService bookWriteService;
	private AddBookRequestTransformer addBookRequestTransformer;

	@Autowired
	public AddBookPostController(BookWriteService bookWriteService, AddBookRequestTransformer addBookRequestTransformer) {
		super();
		this.bookWriteService = bookWriteService;
		this.addBookRequestTransformer = addBookRequestTransformer;
	}

	@ModelAttribute("addBookRequest")
	public AddBookRequest createListBooksModel(@ModelAttribute AddBookRequest addBookRequest) {
		return new AddBookRequest();
	}

	@ModelAttribute("addBookFormModel")
	public AddBookFormModel createListBooksModel() {
		return new AddBookFormModel(Arrays.asList(BookFormat.values()));
	}

	@RequestMapping(value = REQUEST_MAPPING)
	private String createBook(@Valid AddBookRequest addBookRequest, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws IOException {
		String result;
		if (bindingResult.hasErrors()) {
			result = "add_book";
		} else {
			bookWriteService.saveBook(addBookRequestTransformer.transformAddBookRequestToBook(addBookRequest));
			redirectAttributes.addFlashAttribute("message", String.format("Book '%s' of '%s' saved!", addBookRequest.getTitle(), addBookRequest.getAuthor()));
			result = "redirect:addBookForm.html";
		}
		return result;
	}
}

package com.epam.bookshop.stock.view.transform;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.epam.bookshop.book.domain.Book;
import com.epam.bookshop.stock.view.model.AddBookRequest;

@Component
public class AddBookRequestTransformer {
	public Book transformAddBookRequestToBook(AddBookRequest addBookRequest) throws IOException {
		Book result = new Book();
		result.setAuthor(addBookRequest.getAuthor());
		result.setSynopsis(addBookRequest.getSynopsis());
		result.setTitle(addBookRequest.getTitle());
		result.setFormat(addBookRequest.getFormat());
		result.setCover(getCover(addBookRequest));
		return result;

	}

	private byte[] getCover(AddBookRequest addBookRequest) throws IOException {
		byte[] result = null;
		if (addBookRequest.getCover() != null) {
			result = addBookRequest.getCover().getBytes();
		}
		return result;
	}
}

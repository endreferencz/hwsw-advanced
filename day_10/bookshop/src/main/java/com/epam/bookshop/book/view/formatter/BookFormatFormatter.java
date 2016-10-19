package com.epam.bookshop.book.view.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.epam.bookshop.book.domain.BookFormat;

@Component
public class BookFormatFormatter implements Formatter<BookFormat> {

	@Override
	public String print(BookFormat bookFormat, Locale locale) {
		return bookFormat.getDisplayName();
	}

	@Override
	public BookFormat parse(String text, Locale locale) throws ParseException {
		return BookFormat.getByName(text);
	}

}

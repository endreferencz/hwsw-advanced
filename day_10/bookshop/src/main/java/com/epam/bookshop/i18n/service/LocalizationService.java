package com.epam.bookshop.i18n.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class LocalizationService {
	public List<LanguageCode> getAccessibleLanguages() {
		return Arrays.asList(LanguageCode.EN, LanguageCode.HU);
	}

}

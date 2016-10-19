package com.epam.bookshop.authentication.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.epam.bookshop.authentication.domain.BookshopAuthorities;

@Service
public class AuthenticationService {
	public boolean isUserAuthenticated() {
		return SecurityContextHolder.getContext().getAuthentication() != null && SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
	}

	public boolean isUserAdmin() {
		boolean result = false;
		if (isUserAuthenticated()) {
			result = checkAdmin();
		}
		return result;
	}

	private boolean checkAdmin() {
		Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		boolean result = false;
		for (GrantedAuthority authority : authorities) {
			if (authority.getAuthority().equals(BookshopAuthorities.ROLE_ADMIN.name())) {
				result = true;
				break;
			}
		}
		return result;
	}
}

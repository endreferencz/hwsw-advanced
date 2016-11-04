package com.epam.training.javasecurity.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.epam.training.javasecurity.data.User;

public class CustomUserDetails extends User implements UserDetails {

	public CustomUserDetails(User user) {
		super(user);
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<? extends GrantedAuthority> result;
		if (getUsername().equals("peter@example.com")) {
			result =  AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_USER"); 
		}
		else {
			result = AuthorityUtils.createAuthorityList("ROLE_USER"); 
		}
		return result;
	}

	@Override
	public String getUsername() {
		return getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}

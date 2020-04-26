package com.javacode.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.javacode.model.Login;

public class UserDetailsImpl implements UserDetails{

	private String userName;

	private String password;
	


	public UserDetailsImpl(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public UserDetailsImpl(Login user) {
		this.userName = user.getUserName();
		this.password = user.getPassword();
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	public static UserDetailsImpl build(Login user) {

		return new UserDetailsImpl(user.getUserName(), user.getPassword());
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}

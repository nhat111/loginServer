package com.javacode.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.javacode.model.Login;
import com.javacode.repository.LoginRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private LoginRepository loginRepository;
	
	// private UserDetailsImpl userDetailsImpl;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Login user = loginRepository.findByUserName(username)
				.orElseThrow(() -> new UsernameNotFoundException("user not foud"));
		return UserDetailsImpl.build(user);
	}

}

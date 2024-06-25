package com.manish.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.manish.dao.UserRepo;
import com.manish.modal.User;
import com.manish.modal.UserPrinciple;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepo repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username);
		User user = repo.findByUsername(username);
		if(user == null) {
			System.out.println("User 404"+repo.findAll());
			throw new UsernameNotFoundException("User 404");
		}
		return new UserPrinciple(user);
	}

}

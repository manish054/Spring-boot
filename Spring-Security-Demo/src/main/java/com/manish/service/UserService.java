package com.manish.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.manish.dao.UserRepo;
import com.manish.modal.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepo repo;
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	
	public User createUser(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		System.out.println("user.getUsername()--"+user.getUsername());
		return repo.save(user);
	}
}

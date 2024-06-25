package com.manish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.manish.modal.User;
import com.manish.service.JwtService;
import com.manish.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtService jwtService;
	
	@PostMapping("/register")
	public User register(@RequestBody User user) {
		return service.createUser(user);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody User user) {
		System.out.println("UserController---"+user.getUsername());
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		if(authentication.isAuthenticated()) {
			System.out.println("jwtService.generateToken(user.getUsername())---"+jwtService.generateToken(user.getUsername()));
			return jwtService.generateToken(user.getUsername());
//			return "Success";
		}
				
		return "Failed";
	}
}

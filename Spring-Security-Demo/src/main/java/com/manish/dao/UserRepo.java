package com.manish.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manish.modal.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	User findByUsername(String username);
}

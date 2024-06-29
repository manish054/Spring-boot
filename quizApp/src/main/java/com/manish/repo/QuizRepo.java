package com.manish.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manish.modal.Quiz;

@Repository
public interface QuizRepo extends JpaRepository<Quiz, Integer>{

}

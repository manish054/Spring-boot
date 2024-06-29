package com.manish.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.manish.modal.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer>{

	List<Question> findAllByCategory(String category);
	
	@Query(value="SELECT * FROM question q WHERE q.category=:category ORDER BY RANDOM() LIMIT :num", nativeQuery = true)
	List<Question> findRandomQuestionsByCategory(String category, int num);

}

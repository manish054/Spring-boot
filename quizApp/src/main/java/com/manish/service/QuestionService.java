package com.manish.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.manish.modal.Question;
import com.manish.repo.QuestionRepo;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepo qRepo;
	
	public ResponseEntity<List<Question>> getAllQuestions(){
		return new ResponseEntity<>(qRepo.findAll(), HttpStatus.OK);
	}

	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
		// TODO Auto-generated method stub
		try {
			return new ResponseEntity<>(qRepo.findAllByCategory(category), HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<Question> addQuestion(Question question) {
		try {
			qRepo.save(question);
			return new ResponseEntity<>(question, HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<String> deleteQuestion(int id) {
		// TODO Auto-generated method stub
		Optional<Question> ques = qRepo.findById(id);
		if(ques.isPresent()) {
			try {
				qRepo.deleteById(id);
				return new ResponseEntity<>("Deleted", HttpStatus.CREATED);
			}catch(Exception e) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> updateQuestion(Question question) {
		// TODO Auto-generated method stub
		Optional<Question> ques = qRepo.findById(question.getId());
		if(ques.isPresent()) {
			try {
				qRepo.save(question);
				return new ResponseEntity<>("Updated", HttpStatus.OK);
			}catch(Exception e) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}

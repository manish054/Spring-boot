package com.manish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manish.modal.Question;
import com.manish.service.QuestionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	private QuestionService qService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Question>> allQuestions() {
		return qService.getAllQuestions();
	}
	
	@GetMapping("category/{category}")
	public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
		return qService.getQuestionsByCategory(category);
	}
	
	@PostMapping("add")
	public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
		return qService.addQuestion(question);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteQuestion(@PathVariable Integer id) {
		return qService.deleteQuestion(id);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateQuestion(@RequestBody Question question) {
		return qService.updateQuestion(question);
	}
}

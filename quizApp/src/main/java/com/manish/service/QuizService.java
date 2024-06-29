package com.manish.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.manish.modal.Question;
import com.manish.modal.QuestionWrapper;
import com.manish.modal.Quiz;
import com.manish.modal.UserResponse;
import com.manish.repo.QuestionRepo;
import com.manish.repo.QuizRepo;

@Service
public class QuizService {
	
	@Autowired
	private QuizRepo quizRepo;
	
	@Autowired
	private QuestionRepo questionRepo;
	
	public ResponseEntity<String> createQuiz(String category, int num, String title){
		
		List<Question> questions = questionRepo.findRandomQuestionsByCategory(category, num);
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizRepo.save(quiz);
		return new ResponseEntity<>("Created", HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuiz(Integer id) {
		// TODO Auto-generated method stub
		Optional<Quiz> quiz = quizRepo.findById(id);
		List<Question> questionFromDB = quiz.get().getQuestions();
		List<QuestionWrapper> questionForUser = new ArrayList<>();
		
//		questionFromDB.forEach(ques -> 
//		{questionForUser.add(new QuestionWrapper(ques.getId(), ques.getQuestion(), ques.getOption1()
//			, ques.getOption2(), ques.getOption3(), ques.getOption4()))})
		
		questionFromDB.forEach(qus ->{
			QuestionWrapper q = new QuestionWrapper();
			q.setId(qus.getId());
			q.setQuestion(qus.getQuestion());
			q.setOption1(qus.getOption1());
			q.setOption2(qus.getOption2());
			q.setOption3(qus.getOption3());
			q.setOption4(qus.getOption4());
			questionForUser.add(q);
		});
		return new ResponseEntity<>(questionForUser, HttpStatus.OK);
	}

	public ResponseEntity<Integer> getResult(Integer id, List<UserResponse> uResponse) {
		int correctAns = 0;
		int index = 0;
		Optional<Quiz> quiz = quizRepo.findById(id);
		List<Question> ques = quiz.get().getQuestions();
		if(uResponse.size() == 0) {
			return new ResponseEntity<>(correctAns, HttpStatus.BAD_REQUEST);
		}
		
		for(UserResponse res:uResponse) {
//			Optional<Question> quesFromDB = questionRepo.findById(res.getId());
			if(res.getResponse().equals(ques.get(index).getAnswer())) {
				correctAns++;
			}
			index++;
		}
		return new ResponseEntity<>(correctAns, HttpStatus.OK);

	}
}

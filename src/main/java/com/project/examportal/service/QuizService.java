package com.project.examportal.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.examportal.model.exam.Category;
import com.project.examportal.model.exam.Quiz;
import com.project.examportal.repository.QuizRepository;


@Service
@Transactional
public class QuizService {
	
	@Autowired
    private QuizRepository quizRepository;

    
    public Quiz addQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

   
    public Quiz updateQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    public Set<Quiz> getQuizzes() {
        return new HashSet<>(this.quizRepository.findAll());
    }

    
    public Quiz getQuiz(Long quizId) {
        return this.quizRepository.findById(quizId).get();
    }

    public void deleteQuiz(Long quizId) {
        this.quizRepository.deleteById(quizId);
    }

    public List<Quiz> getQuizzesOfCategory(Category category) {
        return this.quizRepository.findBycategory(category);
    }

    public List<Quiz> getActiveQuizzes() {
        return this.quizRepository.findByActive(true);
    }

    public List<Quiz> getActiveQuizzesOfCategory(Category c) {
        return this.quizRepository.findByCategoryAndActive(c, true);
    }

}

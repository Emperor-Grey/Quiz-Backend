package com.kinggrey.quiz.services;

import com.kinggrey.quiz.models.Question;
import com.kinggrey.quiz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * QuestionService
 */

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Question getQuestionById(Long id) {
        return questionRepository.findById(id).orElse(null);
    }

    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    public Question updateQuestion(Long id, Question questionDetails) {
        Question question = questionRepository.findById(id).orElse(null);
        if (question != null) {
            question.setQuestionText(questionDetails.getQuestionText());
            question.setOptions(questionDetails.getOptions());
            return questionRepository.save(question);
        }
        return null;
    }

    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }

}

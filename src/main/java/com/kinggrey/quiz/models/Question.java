package com.kinggrey.quiz.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

/**
 * Question
 */

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "question_text", nullable = false)
    private String questionText;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Option> options;

    public Question(String questionText, List<Option> options) {
        this.questionText = questionText;
        this.options = options;
    }

    public Question(String questionText, Long id, List<Option> options) {
        this.questionText = questionText;
        this.id = id;
        this.options = options;
    }

    public Question() {
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String question) {
        this.questionText = question;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

}

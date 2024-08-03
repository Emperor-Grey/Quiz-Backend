package com.kinggrey.quiz.repository;

import com.kinggrey.quiz.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * QuestionRepository
 */

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}

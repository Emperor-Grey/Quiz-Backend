package com.kinggrey.quiz.repository;

import com.kinggrey.quiz.models.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * OptionRepository
 */

@Repository
public interface OptionRepository extends JpaRepository<Option, Long> {

}

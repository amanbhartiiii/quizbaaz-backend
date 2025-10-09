package com.bharti.quizbaaz_backend.repository;

import com.bharti.quizbaaz_backend.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository<Question, Long> {
}

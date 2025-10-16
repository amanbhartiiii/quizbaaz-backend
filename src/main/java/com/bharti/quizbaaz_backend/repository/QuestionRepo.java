package com.bharti.quizbaaz_backend.repository;

import com.bharti.quizbaaz_backend.entity.Question;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepo extends JpaRepository<Question, Long> {
    List<Question> findBySubject(String subject);
    List<Question> findByTopic(String topic);
    List<Question> findByDifficulty(String difficulty);
    List<Question> findBySubjectAndTopic(String subject, String topic);
    List<Question> findBySubjectAndDifficulty(String subject, String difficulty);
    List<Question> findBySubjectAndTopicAndDifficulty(String subject, String topic, String difficulty);

    @Query("SELECT DISTINCT q.topic FROM Question q WHERE q.subject = :subject")
    List<String> findTopicsBySubject(@Param("subject") String subject);

}

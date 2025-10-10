package com.bharti.quizbaaz_backend.service;

import com.bharti.quizbaaz_backend.dto.QuestionDto;

import java.util.List;

public interface QuestionService {
    QuestionDto addQuestion(QuestionDto questionDto);
    List<QuestionDto> getAllQuestions();
    List<QuestionDto> getQuestionBySub(String subject);
}

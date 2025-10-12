package com.bharti.quizbaaz_backend.controller;

import com.bharti.quizbaaz_backend.dto.QuestionDto;
import com.bharti.quizbaaz_backend.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PostMapping("/add")
    public ResponseEntity<QuestionDto> addQuestion(@RequestBody QuestionDto questionDto) {
        QuestionDto newQuestion = questionService.addQuestion(questionDto);
        return new ResponseEntity<>(newQuestion, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<QuestionDto>> getQuestions(){
        List<QuestionDto> questions = questionService.getAllQuestions();
        return new ResponseEntity<>(questions, HttpStatus.FOUND);
    }
}

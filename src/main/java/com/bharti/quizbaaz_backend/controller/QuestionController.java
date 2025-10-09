package com.bharti.quizbaaz_backend.controller;

import com.bharti.quizbaaz_backend.dto.QuestionDto;
import com.mysql.cj.x.protobuf.Mysqlx;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @PostMapping("/add")
    public ResponseEntity<QuestionDto> addQuestion(@RequestBody QuestionDto questionDto) {
        return new ResponseEntity<>(questionDto, HttpStatus.OK);
    }
}

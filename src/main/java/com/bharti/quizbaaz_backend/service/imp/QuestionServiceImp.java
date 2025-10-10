package com.bharti.quizbaaz_backend.service.imp;

import com.bharti.quizbaaz_backend.dto.QuestionDto;
import com.bharti.quizbaaz_backend.entity.Question;
import com.bharti.quizbaaz_backend.repository.QuestionRepo;
import com.bharti.quizbaaz_backend.service.QuestionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QuestionServiceImp implements QuestionService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private QuestionRepo questionRepo;

    @Override
    public QuestionDto addQuestion(QuestionDto questionDto) {
        Question question = modelMapper.map(questionDto, Question.class);
        Question newQuestion = questionRepo.save(question);
        return modelMapper.map(newQuestion, QuestionDto.class);
    }

    @Override
    public List<QuestionDto> getAllQuestions() {
        return questionRepo.findAll().stream().map(question -> modelMapper.map(question, QuestionDto.class)).toList();
    }

    @Override
    public List<QuestionDto> getQuestionBySub(String subject) {
        return List.of();
    }
}

package com.bharti.quizbaaz_backend.service.imp;

import com.bharti.quizbaaz_backend.dto.QuestionDto;
import com.bharti.quizbaaz_backend.entity.Option;
import com.bharti.quizbaaz_backend.entity.Question;
import com.bharti.quizbaaz_backend.repository.QuestionRepo;
import com.bharti.quizbaaz_backend.service.QuestionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImp implements QuestionService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private QuestionRepo questionRepo;

    @Override
    public QuestionDto addQuestion(QuestionDto questionDto) {
        // 1️⃣ Convert DTO → Entity
        Question question = modelMapper.map(questionDto, Question.class);

        // 2️⃣ Link each Option to its parent Question
        if (question.getOptions() != null) {
            for (Option opt : question.getOptions()) {
                opt.setQuestion(question);
            }
        }

        // 3️⃣ Save Question + Options (Cascade.ALL handles both)
        Question newQuestion = questionRepo.save(question);

        // 4️⃣ Convert back to DTO
        return modelMapper.map(newQuestion, QuestionDto.class);
    }

    @Override
    public List<QuestionDto> getAllQuestions() {
        return questionRepo.findAll().stream().map(question -> modelMapper.map(question, QuestionDto.class)).toList();
    }

    @Override
    public List<QuestionDto> getFilteredQuestion(String subject, String topic, String difficulty) {
        List<Question> questions;

        // Dynamic filter logic
        if(subject != null && topic != null && difficulty != null) {
            questions = questionRepo.findBySubjectAndTopicAndDifficulty(subject, topic, difficulty);
        } else if (subject != null && topic != null) {
            questions = questionRepo.findBySubjectAndTopic(subject, topic);
        } else if (subject != null && difficulty != null) {
            questions = questionRepo.findBySubjectAndDifficulty(subject, difficulty);
        } else if (subject != null) {
            questions = questionRepo.findBySubject(subject);
        } else {
            questions = questionRepo.findAll();
        }
        return questions.stream().map(question -> modelMapper.map(question, QuestionDto.class)).toList();
    }

    @Override
    public List<String> getTopicsBySubject(String subject) {
        return questionRepo.findTopicsBySubject(subject);
    }
}

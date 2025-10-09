package com.bharti.quizbaaz_backend.dto;

import com.bharti.quizbaaz_backend.entity.Option;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class QuestionDto {
    private Long id;
    private String text;
    private String subject;
    private String topic;
    private String difficulty;
    private List<OptionDto> options = new ArrayList<>();
}

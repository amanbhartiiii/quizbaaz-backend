package com.bharti.quizbaaz_backend.dto;

import lombok.Data;

@Data
public class OptionDto {
    private Long id;
    private String text;
    private boolean correct;
}

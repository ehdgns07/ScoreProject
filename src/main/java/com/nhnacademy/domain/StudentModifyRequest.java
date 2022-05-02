package com.nhnacademy.domain;

import lombok.Value;

@Value
public class StudentModifyRequest {
    private String name;
    private String email;
    private int score;
    private String comment;
}

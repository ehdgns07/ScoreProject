package com.nhnacademy.domain;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
    private long id;
    private String name;
    private String email;
    private int score;
    private String comment;

    public Student(long id, String name, String email, int score, String comment) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.score = score;
        this.comment = comment;
    }



}

package com.nhnacademy.domain;


import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import lombok.Value;
import org.hibernate.validator.constraints.Length;

@Value
public class StudentRegisterRequest {
    @NotBlank
    private String name;
    @Email
    private String email;
    @Min(0)
    @Max(100)
    private int score;
    @NotBlank
    @Length(max = 200)
    private String comment;
}

package com.nhnacademy.controller;

import com.nhnacademy.domain.Student;
import com.nhnacademy.domain.StudentRegisterRequest;
import com.nhnacademy.exception.ValidationFailedException;
import com.nhnacademy.repository.StudentRepository;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/student/register")
public class StudentRegisterController {
    private final StudentRepository studentRepository;

    public StudentRegisterController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public String studentRegisterForm() {
        return "studentRegister";
    }

    @PostMapping
    public ModelAndView registerStudent(@Valid @ModelAttribute StudentRegisterRequest studentRegisterRequest, BindingResult bindingResult)
        throws ValidationFailedException {
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult);
        }

        Student student = studentRepository.register(studentRegisterRequest.getName(),studentRegisterRequest.getEmail(),studentRegisterRequest.getScore(),studentRegisterRequest.getComment());

        ModelAndView mav = new ModelAndView("studentView");
        mav.addObject("student",student);
        return mav;
    }

}

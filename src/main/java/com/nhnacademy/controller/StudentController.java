package com.nhnacademy.controller;

import com.nhnacademy.domain.Student;
import com.nhnacademy.exception.StudentNotFoundException;
import com.nhnacademy.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/student")
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @ModelAttribute("student")
    public Student getStudent(@PathVariable("studentId") long studentId){
        Student student =studentRepository.getStudent(studentId);

        return student;
    }

    @GetMapping("/{studentId}")
    public String viewStudent(@ModelAttribute Student student, Model model, @PathVariable long studentId) {
        model.addAttribute("student",studentRepository.getStudent(student.getId()));
        if(studentRepository.exists(studentId)){
            notFound();
        }
        return "studentView";
    }

    @GetMapping("/{studentId}/modify")
    public String studentModifyForm(@ModelAttribute Student student,Model model,@PathVariable long studentId) {
        if(studentRepository.exists(studentId)){
            notFound();
        }
        model.addAttribute("student", student);
        return "studentModify";
    }

    @PostMapping("/{studentId}/modify")
    public String modifyStudent(@ModelAttribute Student student, Model model,@PathVariable long studentId) {
        if(studentRepository.exists(studentId)){
            notFound();
        }
        Student afterModifyStudent = studentRepository.modify(student.getId(),student.getName(),student.getEmail(),student.getScore(),student.getComment());
        model.addAttribute("student", afterModifyStudent);
        return "studentView";
    }

    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void notFound() {

    }

}

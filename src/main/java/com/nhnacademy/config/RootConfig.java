package com.nhnacademy.config;

import com.nhnacademy.Base;
import com.nhnacademy.controller.ControllerBase;
import com.nhnacademy.repository.StudentRepository;
import com.nhnacademy.repository.StudentRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackageClasses = Base.class,
                excludeFilters = {@ComponentScan.Filter(Controller.class)})//stereoType을 왜 걸러줄까?
public class RootConfig {
    @Bean
    public StudentRepository studentRepository() {
        StudentRepository studentRepository = new StudentRepositoryImpl();
        studentRepository.register("김학생", "kim.student@nhnacademy.com", 100, "훌륭");

        return studentRepository;
    }
}

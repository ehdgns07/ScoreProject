package com.nhnacademy.repository;


import com.nhnacademy.domain.Student;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class StudentRepositoryImpl implements StudentRepository {
    Map<String, Student> studentMap = new HashMap<>();
    @Override
    public boolean exists(long id) {

        return Objects.isNull(studentMap.get(String.valueOf(id)));
    }

    @Override
    public Student register(String name, String email, int score, String comment) {
        if(exists(studentMap.size())){
//            throw new UserExistsEcxeption;
        }
        studentMap.put(String.valueOf(studentMap.size()), new Student(studentMap.size(),name,email,score,comment));
        return this.studentMap.get(String.valueOf(studentMap.size()-1));
    }

    @Override
    public Student getStudent(long id) {
        return this.studentMap.get(String.valueOf(id));
    }

    @Override
    public Student modify(long id, String name, String email, int score, String comment){
        this.studentMap.get(String.valueOf(id)).setName(name);
        this.studentMap.get(String.valueOf(id)).setEmail(email);
        this.studentMap.get(String.valueOf(id)).setScore(score);
        this.studentMap.get(String.valueOf(id)).setComment(comment);

        return this.studentMap.get(String.valueOf(id));
    }
}

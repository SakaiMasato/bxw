package com.bxw.controller;

import com.bxw.entity.Student;
import com.bxw.mapperA.StudentMapperA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddStudentA {

    @Autowired
    private StudentMapperA studentMapperA;

    @GetMapping("/addStudentsA")
    public boolean addStudentsA(Student student){
        return studentMapperA.addStudent(student);
    }
}

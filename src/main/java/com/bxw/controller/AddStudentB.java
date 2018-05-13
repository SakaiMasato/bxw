package com.bxw.controller;

import com.bxw.entity.Student;
import com.bxw.mapperB.StudentMapperB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddStudentB {

    @Autowired
    private StudentMapperB studentMapperB;

    @GetMapping("/addStudentsB")
    public boolean addStudentsA(Student student){
        return studentMapperB.addStudent(student);
    }
}

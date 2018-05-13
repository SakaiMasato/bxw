package com.bxw.service;

import com.bxw.dao.TeacherDao;
import com.bxw.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherDao teacherDao;

    public List<Teacher>  findTeachers(){
        return teacherDao.findAll();
    }
}

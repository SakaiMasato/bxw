package com.bxw.dao;

import com.bxw.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

//Integer是主键的类型
public interface TeacherDao extends JpaRepository<Teacher,Integer> {
}

package com.bxw.mapperA;

import com.bxw.entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 声明式事务加上@Transactional注解即可
 */
@Repository
@Mapper
public interface StudentMapperA {

    @Select("select * from student where id = #{id}")
    Student findStudent(@Param("id") int id);

    @Select("select * from student")
    List<Student> findAll();

    @Insert("insert into student(id,name,sex) values(#{s.id},#{s.name},#{s.sex})")
    boolean addStudent(@Param("s") Student student);
}

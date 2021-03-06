package com.bxw.mapperB;

import com.bxw.entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface StudentMapperB {

    @Select("select * from student where id = #{id}")
    Student findStudent(@Param("id") int id);

    @Insert("insert into student(id,name,sex) values(#{s.id},#{s.name},#{s.sex})")
    boolean addStudent(@Param("s") Student student);
}

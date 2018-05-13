package com.bxw.service;

import com.bxw.annotation.DB;
import com.bxw.entity.Student;
import com.bxw.mapperTA.StudentMapperTA;
import com.bxw.mapperTB.StudentMapperTB;
import com.bxw.mapperDynamic.StudentMapperC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private StudentMapperC studentMapperC;
    @Autowired
    private StudentMapperTA studentMapperTA;
    @Autowired
    private StudentMapperTB studentMapperTB;


    public List findStudents(){
        List<Student> list = jdbcTemplate.query("select * from student",new StudentRowMapper());
        return list;
    }

    /**
     * 动态数据源
     */
    @DB
    public List<Student> db1(){
        return studentMapperC.findAll();
    }

    @DB("db2")
    public List<Student> db2(){
        return studentMapperC.findAll();
    }

/*
分布式事务
 */
    @Transactional
    public boolean saveStudent(Student s){
        studentMapperTA.addStudent(s);
        studentMapperTB.addStudent(s);
        int i = 1/0;
        return true;
    }

    class StudentRowMapper implements RowMapper{

        @Override
        public Object mapRow(ResultSet resultSet, int i) throws SQLException {
            Student s = new Student();
            s.setId(resultSet.getInt("id"));
            s.setName(resultSet.getString("name"));
            s.setSex(resultSet.getString("sex"));
            return s;
        }
    }
}

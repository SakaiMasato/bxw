package com.bxw.controller;

import com.bxw.annotation.DB;
import com.bxw.entity.Student;
import com.bxw.entity.Teacher;
import com.bxw.mapperA.StudentMapperA;
import com.bxw.service.AsyncService;
import com.bxw.service.RedisService;
import com.bxw.service.StudentService;
import com.bxw.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//@EnableAutoConfiguration
@RestController//该注解标明该类全部返回json格式
public class HellowordController {
    private Logger log = LoggerFactory.getLogger(HellowordController.class);
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentMapperA studentMapperA;
    @Autowired
    private AsyncService asyncService;
    @Autowired
    private RedisService redisService;

    @ResponseBody
    @GetMapping("/hello")
    public String sayHello(){
        log.info("==============hello world=====================");
        return "hello springboot";
    }

    @ResponseBody
    @GetMapping("/getmessage")
    public Map getMsg(){
        Map<String,String> result = new HashMap<String,String>();
        result.put("errorCode","200");
        result.put("msg","success");
        return result;
    }

    @GetMapping("/findStudents")
    @ResponseBody
    public List<Student> findStudents(){
        return studentService.findStudents();
    }

    //动态数据源
    @GetMapping("/findStudentA")
    @ResponseBody
    public List<Student> findStudentsA(){
        return studentService.db1();
    }
    @GetMapping("/findStudentB")
    @ResponseBody
    public List<Student> findStudentsB(){
        return studentService.db2();
    }

    //分布式事务
    @GetMapping("/saveStudentT")
    @ResponseBody
    public boolean saveStudentT(Student s){
        return studentService.saveStudent(s);
    }

    @GetMapping("/findTeachers")
    @ResponseBody
    public List<Teacher> findTeachers(){
        return teacherService.findTeachers();
    }

    //异步
    @GetMapping("/sendMsg")
    @ResponseBody
    public String sendMsg(){
        //output:3412
        System.out.println("==============getMsg===============3");
        asyncService.sendSms();
        System.out.println("=============getMsg================4");
        return "success";
    }

    //redis
    @GetMapping("/setString")
    @ResponseBody
    public String setString(String key,String value){
        redisService.setString(Optional.of(key),Optional.of(value),null);
        return "success";
    }

    @GetMapping("/getValue")
    @ResponseBody
    public String getValue(String key){
        return redisService.getValue(Optional.of(key));
    }
//    public static void main(String[] args){
//        SpringApplication.run(HellowordController.class,args);
//    }

}

package com.bxw.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@SpringBootApplication该注解整合常用注解，扫包扫当前包下（@Configuration,@ComponentScan,@EnableAutoConfiguration）
//@ComponentScan(basePackages = {"com.bxw.controller","com.bxw.service","com.bxw.entity"})
////jpa扫描开始
//@EnableJpaRepositories("com.bxw.dao")
//@EntityScan("com.bxw.entity")
////jpa实体类扫描结束
////mybatis扫描开始
//@MapperScan("com.bxw.mapperA")
////mybatis扫描结束
//@EnableAutoConfiguration
//public class App {
//    public static void main(String[] args){
//            SpringApplication.run(App.class,args);
//    }
//}

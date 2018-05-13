package com.bxw;

import com.bxw.configuration.DBConfig1;
import com.bxw.configuration.DBConfig2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication()
@EnableConfigurationProperties(value = {DBConfig1.class, DBConfig2.class})
@EnableAsync//启用异步
public class App {
    public static void main(String[] args){
            SpringApplication.run(App.class,args);
    }
}

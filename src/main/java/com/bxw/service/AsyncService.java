package com.bxw.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    @Async
    public void sendSms(){
        System.out.println("===========sendSms================1");
        System.out.println("===========sendSms================2");
    }
}

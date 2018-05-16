package com.bxw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void setString(Optional<String> key, Optional<Object> value, Long time){
        this.setObject(key,value,time);
    }
    private void setObject(Optional<String> key, Optional<Object> value, Long time){
        if(key.isPresent() && value.isPresent()){
            String key1 = key.get();
            Object val1 = value.get();

            if(val1 instanceof String){
                String strVal = (String) val1;
                stringRedisTemplate.opsForValue().set(key1,strVal);
                if(time != null){
                    stringRedisTemplate.opsForValue().set(key1,strVal,time, TimeUnit.SECONDS);
                }
                return;
            }
        }
    }
    public String getValue(Optional<String> key){
        if(key.isPresent()){
            return stringRedisTemplate.opsForValue().get(key.get());
        }
        return null;
    }
}

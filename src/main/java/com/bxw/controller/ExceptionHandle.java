package com.bxw.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理
 */
@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map getMessage(){
        Map result = new HashMap();
        result.put("errCode","500");
        result.put("msg","error");
        return result;
    }
}

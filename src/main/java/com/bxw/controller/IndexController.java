package com.bxw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.TokenService;

import java.util.Map;

@Controller
public class IndexController {
    @Autowired
    private TokenService tokerService;

    @GetMapping("/index")
    public String index(Map map){
        map.put("name","bxw");
        return "index";
    }

    @GetMapping("/token")
    @ResponseBody
    public String token(){
        return tokerService.getToken();
    }
}

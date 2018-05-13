package com.bxw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class IndexController {
    @GetMapping("/index")
    public String index(Map map){
        map.put("name","bxw");
        return "index";
    }

}

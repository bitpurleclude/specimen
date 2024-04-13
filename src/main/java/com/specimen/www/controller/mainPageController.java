package com.specimen.www.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class mainPageController {
    @RequestMapping({"/","/hello"})
    public static String  hello(){
        return "hello";
    }
}

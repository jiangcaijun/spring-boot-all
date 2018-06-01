package com.joe.mybatis.controller;

import com.joe.mybatis.service.ZcdcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private ZcdcService zcdcService;

    @GetMapping("/test")
    public Object test(){
        for(int i = 0; i < 10; i++){
            System.out.println(zcdcService.queryById(i + ""));
        }
        return "success";
    }

}

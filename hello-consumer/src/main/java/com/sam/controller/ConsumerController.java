package com.sam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sam.service.ConsumerService;

@RestController
public class ConsumerController {

    //这里注入的restTemplate就是在com.sam.ConsumerApp中通过@Bean配置的实例
    @Autowired
    ConsumerService service;

    @RequestMapping("/hello")
    public String helloConsumer() {
       
    	return service.consumer();
    }
    
    public String errorMsg() {
        return "error!!!";
    }
}

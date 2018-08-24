package com.sam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sam.entity.User;
import com.sam.service.FeignConsumerService;

@RestController
public class FeiConsumerController {

    @Autowired
    FeignConsumerService consumerService;

    @RequestMapping("feign-consumer")
    public String feignConsumer() {
        consumerService.hello();
        return "feign consumer call finished!!!";
    }

    @RequestMapping("feign-consumer-user")
    public User feignConsumer2(User user) {
        consumerService.hello2();
        System.out.println(user.getName()+"---------------"+user.getAge());
        return consumerService.printUser(user);
    }
    
    @RequestMapping(value = "feign-consumer-id",method = RequestMethod.GET)
    public String feignConsumer3(@RequestParam("id") Long id) {
     
        System.out.println("id:"+id);
        return "id"+id;
    }
}
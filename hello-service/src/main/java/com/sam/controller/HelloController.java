package com.sam.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sam.entity.User;
import com.sam.service.HelloService;

@RestController
public class HelloController  implements HelloService{

    Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    DiscoveryClient discoveryClient;
    
    @RequestMapping("/hello")
    public String hello() {
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        //打印服务的服务id
        logger.info("*********" + instance.getServiceId());
        return "hello,this is hello-service";
    }
    
    @RequestMapping("/test")
    public String test() {
       // ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        //打印服务的服务id
     //   logger.info("*********" + instance.getServiceId());
        return "hello,this is hello-service";
    }

	@Override
	public String hello2() {
		// TODO Auto-generated method stub
		  return "hello,this is hello2-service";
	}

	public User printUser(@RequestBody User user) {
        System.out.println(user.getName()+"---------------"+user.getAge());
		 return user;
	}

}

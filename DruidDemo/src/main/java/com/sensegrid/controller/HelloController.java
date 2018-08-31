package com.sensegrid.controller;

import org.springframework.web.bind.annotation.RestController;

import com.sensegrid.bean.Account;
import com.sensegrid.interf.IAccountService;
import com.sensegrid.service.RedisService;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@RestController
public class HelloController {
	@Autowired
	//ʹ��@Qualifier����ʾSpring����ʲô���͵��������ñ���IoC
	@Qualifier("accountService")
    private IAccountService accService;
    @RequestMapping("/accService")
    public  List<Account> getAccounts(){
        return accService.findAccountList();
     }
    
    @Autowired
    private RedisService redisService ;
    @RequestMapping(value = "/test")
    public String demoTest(){
        redisService.set("test","value22222");
        return  (String) redisService.get("test");
    }

}

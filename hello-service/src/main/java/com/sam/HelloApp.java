package com.sam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/***
 * 
 * @EnableDiscoveryClient
 * �÷���ʹ��eureka������
 * ʵ�ַ���ע��ͷ���
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
public class HelloApp {

    public static void main(String[] args) {

        SpringApplication.run(HelloApp.class, args);
    }

}
package com.sam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import zipkin.server.EnableZipkinServer;

/**
 * @EnableZipkinServer
 * 
 * 用于开启Zipkin Server功能
 *
 */
@EnableZipkinServer
@SpringBootApplication
@EnableDiscoveryClient
public class SleuthZipkinApp {

    public static void main(String[] args) {
        SpringApplication.run(SleuthZipkinApp.class, args);
    }

}
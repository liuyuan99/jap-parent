package com.liuyuan.jpasc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
//@ComponentScan(value = {"com.liuyuan.jpasc","com.liuyuan.jpasc"})
public class ServiceStart {
    public static void main(String[] args) {
        SpringApplication.run(ServiceStart.class,args);
    }
}

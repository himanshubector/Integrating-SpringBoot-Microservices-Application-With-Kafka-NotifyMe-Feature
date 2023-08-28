package com.hims.user.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.kafka.annotation.EnableKafka;


@SpringBootApplication
@EnableDiscoveryClient
@EnableKafka
public class UserServiceApplication
{
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }
}

package com.cskaoyan.mall_springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.cskaoyan.mall_springboot.mapper")
public class MallSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallSpringbootApplication.class, args);
    }

}

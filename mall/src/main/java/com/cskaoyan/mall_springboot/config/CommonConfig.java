package com.cskaoyan.mall_springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * @author CZY-Y7000P
 */
@Configuration
public class CommonConfig {
    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
//        resolver.setDefaultEncoding("UTF-8");
//        resolver.setResolveLazily(true);
//        resolver.setMaxInMemorySize(40960);
        //上传文件大小 50M 50*1024*1024
        resolver.setMaxUploadSize(50*1024*1024);
        return resolver;
    }
}

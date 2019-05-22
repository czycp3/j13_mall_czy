package com.cskaoyan.mall_springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.cskaoyan.mall_springboot.property.DataSourceProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author CZY-Y7000P
 */
@Configuration
public class DataSourceConfig {

    @Bean("mydb")
	public DataSource dataSource(DataSourceProperty properties){
		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setDriverClassName(properties.getDriverClassName());
		druidDataSource.setUrl(properties.getUrl());
		druidDataSource.setUsername(properties.getUsername());
		druidDataSource.setPassword(properties.getPassword());
		return druidDataSource;
	}
}

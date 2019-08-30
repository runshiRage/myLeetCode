package com.kimorebi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.kimorebi.dao"}) //扫描DAO
public class MybatisPlusApplication {
    
	public static void main(String[] args) {
        SpringApplication.run(MybatisPlusApplication.class, args);
    }
}

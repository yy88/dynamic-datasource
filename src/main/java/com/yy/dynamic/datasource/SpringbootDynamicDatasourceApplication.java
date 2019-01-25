package com.yy.dynamic.datasource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@MapperScan(basePackages = "com.yy.dynamic.datasource.com.dao")
public class SpringbootDynamicDatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDynamicDatasourceApplication.class, args);
    }
}

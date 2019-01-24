package com.yy.springbootmybatismapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@MapperScan(basePackages = "com.yy.springbootmybatismapper.com.dao")
public class SpringbootMybatisMapperApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisMapperApplication.class, args);
    }
}

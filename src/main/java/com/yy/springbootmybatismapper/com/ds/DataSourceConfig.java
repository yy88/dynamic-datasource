package com.yy.springbootmybatismapper.com.ds;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author yuanyuan.jing 2019/1/24 17:37
 */
@Configuration
public class DataSourceConfig {
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource01")
    public DataSource dataSource01(){
        return DataSourceBuilder.create()
                .type(DruidDataSource.class)
                .build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource02")
    public DataSource dataSource02(){
        return DataSourceBuilder.create()
                .type(DruidDataSource.class)
                .build();
    }


}

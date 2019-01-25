package com.yy.springbootmybatismapper.com.ds;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yuanyuan.jing 2019/1/24 17:37
 * springboot集成mybatis的基本入口
 * 1）创建数据源(如果采用的是默认的tomcat-jdbc数据源，则不需要)
 * 2）创建SqlSessionFactory
 * 3）配置事务管理器，除非需要使用事务，否则不用配置
 */
@Configuration
public class DataSourceConfig {
    @Autowired
    private Environment env;
    @Bean
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

    /**
     * @Primary 该注解表示在同一个接口有多个实现类可以注入的时候，默认选择哪一个，而不是让@autowire注解报错
     * @Qualifier 根据名称进行注入，通常是在具有相同的多个类型的实例的一个注入（例如有多个DataSource类型的实例）
     * @return
     */
    @Bean
    @Primary
    public DataSource dataSource(
            @Autowired @Qualifier("dataSource01") DataSource dataSource01,
            @Autowired @Qualifier("dataSource02") DataSource dataSource02
    ){
        Map<Object, Object> map = new HashMap<>();
        map.put("datasource01", dataSource01);
        map.put("datasource02", dataSource02);

        MultipleDataSourceToChoose multipleDataSourceToChoose = new MultipleDataSourceToChoose();
        multipleDataSourceToChoose.setTargetDataSources(map);
        multipleDataSourceToChoose.setDefaultTargetDataSource(dataSource01);
        return multipleDataSourceToChoose;
    }

    /**
     * 根据数据源创建SqlSessionFactory
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource01") DataSource dataSource01,
                                               @Qualifier("dataSource02") DataSource dataSource02) throws Exception{
        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        // 指定数据源(这个必须有，否则报错)
        fb.setDataSource(this.dataSource(dataSource01, dataSource02));
        // 下边两句仅仅用于*.xml文件，如果整个持久层操作不需要使用到xml文件的话（只用注解就可以搞定），则不加
        fb.setTypeAliasesPackage(env.getProperty("mybatis.typeAliasesPackage"));
        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis.mapperLocations")));
        return fb.getObject();
    }

    /**
     * 配置事务管理器(需要使用事务就配置，不需要事务则无需配置)
     */
    @Bean
    public DataSourceTransactionManager transactionManager(MultipleDataSourceToChoose dataSource) throws Exception {
        return new DataSourceTransactionManager(dataSource);
    }


}

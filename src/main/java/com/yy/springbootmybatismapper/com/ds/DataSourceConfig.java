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

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yuanyuan.jing 2019/1/24 17:37
 */
@Configuration
public class DataSourceConfig {
    @Autowired
    private Environment env;
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource01")
    public DataSource dataSource_0(){
        return DataSourceBuilder.create()
                .type(DruidDataSource.class)
                .build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource02")
    public DataSource dataSource_1(){
        return DataSourceBuilder.create()
                .type(DruidDataSource.class)
                .build();
    }


    @Bean
    @Primary
    public DataSource dataSource(
            @Autowired @Qualifier("dataSource_0") DataSource dataSource_0,
            @Autowired @Qualifier("dataSource_1") DataSource dataSource_1
    ){
        Map<Object, Object> map = new HashMap<>();
        map.put("datasource01", dataSource_0);
        map.put("datasource02", dataSource_1);

        MultipleDataSourceToChoose multipleDataSourceToChoose = new MultipleDataSourceToChoose();
        multipleDataSourceToChoose.setTargetDataSources(map);
        multipleDataSourceToChoose.setDefaultTargetDataSource(dataSource_0);
        return multipleDataSourceToChoose;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource_0") DataSource myTestDbDataSource,
                                               @Qualifier("dataSource_1") DataSource myTestDb2DataSource) throws Exception{
        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        fb.setDataSource(this.dataSource(myTestDbDataSource, myTestDb2DataSource));
        fb.setTypeAliasesPackage(env.getProperty("mybatis.typeAliasesPackage"));
        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis.mapperLocations")));
        return fb.getObject();
    }

}

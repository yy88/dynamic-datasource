package com.yy.dynamic.datasource;

import com.yy.dynamic.datasource.com.ds.service.DynamicDataSourceService;
import com.yy.dynamic.datasource.com.entity.Country;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author yuanyuan.jing 2019/1/24 17:23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DynamicDatasourceTest {
    @Autowired
    private DynamicDataSourceService dataSourceService;


    @Test
    public void testDatasource01() {
        Country country = dataSourceService.selectByKey_datasource01(1L);
        System.out.println(country);
    }

    @Test
    public void testDatasource02() {
        Country country = dataSourceService.selectByKey_datasource02(1L);
        System.out.println(country);
    }
}

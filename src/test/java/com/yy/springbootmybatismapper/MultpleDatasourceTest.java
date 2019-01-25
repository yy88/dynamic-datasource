package com.yy.springbootmybatismapper;

import com.yy.springbootmybatismapper.com.dao.CountryDao;
import com.yy.springbootmybatismapper.com.ds.HandlerDataSource;
import com.yy.springbootmybatismapper.com.entity.Country;
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
public class MultpleDatasourceTest {
    @Autowired
    private CountryDao countryDao;
    @Test
    public void test01() {
        HandlerDataSource.putDataSource("datasource01");
        Country country = countryDao.selectByPrimaryKey(1);
        System.out.println("country:"+country);
    }

    @Test
    public void test02() {
        HandlerDataSource.putDataSource("datasource02");
        Country country = countryDao.selectByPrimaryKey(1);
        System.out.println("country:"+country);
    }
}

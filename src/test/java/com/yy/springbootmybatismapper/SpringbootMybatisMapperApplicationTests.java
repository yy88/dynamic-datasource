package com.yy.springbootmybatismapper;

import com.yy.springbootmybatismapper.com.dao.CountryDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.yy.springbootmybatismapper.com.entity.Country;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMybatisMapperApplicationTests {
    @Autowired
    private CountryDao countryDao;
    @Test
    public void contextLoads() {
        Country country = countryDao.selectByPrimaryKey(1);
        System.out.println("country:"+country);
    }

}

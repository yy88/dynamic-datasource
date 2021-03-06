package com.yy.dynamic.datasource.com.ds.service;

import com.yy.dynamic.datasource.com.dao.CountryDao;
import com.yy.dynamic.datasource.com.ds.DynamicSwitchDataSource;
import com.yy.dynamic.datasource.com.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yuanyuan.jing 2019/1/25 11:18
 * 动态数据源测试用
 */
@Service
public class DynamicDataSourceService {
    @Autowired
    private CountryDao countryDao;

    @DynamicSwitchDataSource(dataSource = "datasource01")
    public Country selectByKey_datasource01(Long id){
        return countryDao.selectByPrimaryKey(id);
    }

    @DynamicSwitchDataSource(dataSource = "datasource02")
    public Country selectByKey_datasource02(Long id){
        return countryDao.selectByPrimaryKey(id);
    }
}

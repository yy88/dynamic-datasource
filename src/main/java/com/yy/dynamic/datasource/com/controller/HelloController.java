package com.yy.dynamic.datasource.com.controller;

import com.yy.dynamic.datasource.com.dao.CountryDao;
import com.yy.dynamic.datasource.com.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private CountryDao countryDao;


    @RequestMapping("/hi")
    public Country hi(){
        Country country = countryDao.selectByPrimaryKey(1);
        System.out.println("country:"+country);
        return country;
    }



}

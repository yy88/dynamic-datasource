package com.yy.springbootmybatismapper.com.controller;

import com.yy.springbootmybatismapper.com.dao.CountryDao;
import com.yy.springbootmybatismapper.com.dao.UserInfoDao;
import com.yy.springbootmybatismapper.com.entity.Country;
import com.yy.springbootmybatismapper.com.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {
    @Autowired
    private CountryDao countryDao;

    @Autowired
    private UserInfoDao userInfoDao;


    @RequestMapping("/hi")
    public Country hi(){
        Country country = countryDao.selectByPrimaryKey(1);
        System.out.println("country:"+country);
        return country;
    }

    @RequestMapping("/user/list")
    public List<UserInfo> list(){
        return userInfoDao.selectAll();
    }

}

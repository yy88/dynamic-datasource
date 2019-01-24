package com.yy.springbootmybatismapper.com.ds;

/**
 * @author yuanyuan.jing 2019/1/24 17:12
 * @description： 创建拦截设置数据源的注解
 */


import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DynamicSwitchDataSource {
    String dataSource() default "";
}

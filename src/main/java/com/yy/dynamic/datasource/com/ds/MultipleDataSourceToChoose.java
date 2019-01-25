package com.yy.dynamic.datasource.com.ds;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author yuanyuan.jing 2019/1/24 17:09
 */
public class MultipleDataSourceToChoose extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return HandlerDataSource.getDataSource();
    }
}

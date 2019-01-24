package com.yy.springbootmybatismapper.com.ds;

/**
 * @author yuanyuan.jing 2019/1/24 17:10
 */
public class HandlerDataSource {
    private static ThreadLocal<String> handlerThredLocal = new ThreadLocal<String>();

    /**
     * @desction: 提供给AOP去设置当前的线程的数据源的信息
     */
    public static void putDataSource(String datasource) {
        handlerThredLocal.set(datasource);
    }

    /**
     * @desction: 提供给AbstractRoutingDataSource的实现类，通过key选择数据源
     */
    public static String getDataSource() {
        return handlerThredLocal.get();
    }

    /**
     * @desction: 使用默认的数据源
     */
    public static void clear() {
        handlerThredLocal.remove();
    }


}

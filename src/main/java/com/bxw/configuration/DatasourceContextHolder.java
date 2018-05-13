package com.bxw.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DatasourceContextHolder {
    public static final Logger log = LoggerFactory.getLogger(DatasourceContextHolder.class);

    public static final String primary_DB = "db1";

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();
    //设置数据源名
    public static void setDB(String dbType){
        log.debug("切换到{}数据源",dbType);
        contextHolder.set(dbType);
    }

    //获取数据源名
    public static String getDB(){
        return contextHolder.get();
    }

    //清除数据源名
    public static void clearDB(){
        contextHolder.remove();
    }
}

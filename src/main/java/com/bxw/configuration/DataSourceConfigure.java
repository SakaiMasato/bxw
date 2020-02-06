package com.bxw.configuration;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfigure {
    @Bean(name = "db1")
    @ConfigurationProperties(prefix = "spring.datasource.db1") // application.yml.properteis中对应属性的前缀
    public DataSource dataSource1() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "db2")
    @ConfigurationProperties(prefix = "spring.datasource.db2") // application.yml.properteis中对应属性的前缀
    public DataSource dataSource2() {
        return DataSourceBuilder.create().build();
    }

    //动态数据源
    @Bean(name="dynamicDB1")
    public DataSource dataSource(){
        DynamicDatasource dynamicDatasource = new DynamicDatasource();
        //默认数据源
        dynamicDatasource.setDefaultTargetDataSource(dataSource1());

        Map<Object,Object> dbMap = new HashMap(5);
        dbMap.put("db1",dataSource1());
        dbMap.put("db2",dataSource2());
        dynamicDatasource.setTargetDataSources(dbMap);
        return dynamicDatasource;
    }
}

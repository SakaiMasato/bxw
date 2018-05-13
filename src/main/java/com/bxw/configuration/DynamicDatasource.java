package com.bxw.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDatasource extends AbstractRoutingDataSource {

    private static Logger log = LoggerFactory.getLogger(DynamicDatasource.class);

    @Override
    protected Object determineCurrentLookupKey() {
        log.debug("数据源为{}",DatasourceContextHolder.getDB());
        return DatasourceContextHolder.getDB();
    }
}

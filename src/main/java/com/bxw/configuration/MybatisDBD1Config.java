package com.bxw.configuration;

import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * 分布式事务管理
 */
@Configuration
@MapperScan(basePackages = "com.bxw.mapperTA", sqlSessionTemplateRef = "sqlSessionTemplateT1")
public class MybatisDBD1Config {
    @Primary
    @Bean(name = "datasourceT1")
    public DataSource dataSource(DBConfig1 dbConfig1)throws SQLException{
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl(dbConfig1.getUrl());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setPassword(dbConfig1.getPassword());
        mysqlXaDataSource.setUser(dbConfig1.getUsername());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);

        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);
        xaDataSource.setUniqueResourceName("dbb1");

//        xaDataSource.setMinPoolSize(dbConfig1.getMinPoolSize());
//        xaDataSource.setMaxPoolSize(dbConfig1.getMaxPoolSize());
//        xaDataSource.setMaxLifetime(dbConfig1.getMaxLifetime());
//        xaDataSource.setBorrowConnectionTimeout(dbConfig1.getBorrowConnectionTimeout());
//        xaDataSource.setLoginTimeout(dbConfig1.getLoginTimeout());
//        xaDataSource.setMaintenanceInterval(dbConfig1.getMaintenanceInterval());
//        xaDataSource.setMaxIdleTime(dbConfig1.getMaxIdleTime());
//        xaDataSource.setTestQuery(dbConfig1.getTestQuery());
        return xaDataSource;
    }

    @Bean(name = "sqlSessionFactoryT1")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("datasourceT1") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource); // 使用db1数据源, 连接hibernate库

        return factoryBean.getObject();

    }

    @Bean(name="sqlSessionTemplateT1")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactoryT1") SqlSessionFactory sqlSessionFactory) throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory); // 使用上面配置的Factory
        return template;
    }
}

package com.levon.cms.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {

    @Bean("db1Source")
    @ConfigurationProperties(prefix = "db1.datasource")
    public DataSource db1Source() {
        return DataSourceBuilder.create().build();
    }

    @Bean("db2Source")
    @ConfigurationProperties(prefix = "db2.datasource")
    public DataSource db2Source() {
        return DataSourceBuilder.create().build();
    }

    /**
     * @description: 动态数据库配置
     * @author: levon
     * @createDate: 2019-04-03 22:15
     */
    @Primary
    @Bean("dynamicDataSource")
    public DataSource dynamicDataSource() {

        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        // 默认数据源 db1
        dynamicDataSource.setDefaultTargetDataSource(db1Source());

        Map<Object, Object> dsMap = new HashMap<>();
        dsMap.put("db1", db1Source());
        dsMap.put("db2", db2Source());

        dynamicDataSource.setTargetDataSources(dsMap);

        return dynamicDataSource;
    }

    /**
     * @description: 配置 @Transactional
     * @author: levon
     * @createDate: 2019-04-03 22:15
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }

}

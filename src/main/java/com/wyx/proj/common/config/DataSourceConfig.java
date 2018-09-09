package com.wyx.proj.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class DataSourceConfig implements EnvironmentAware {

    /*
    实现EnvironmentAware接口重写setEnvironment方法可以获取到系统的环境变量
     */
    private RelaxedPropertyResolver properties;

    @Override
    public void setEnvironment(Environment environment) {
        /*
        通过pproperties的前缀获取
         */
        this.properties = new RelaxedPropertyResolver(environment,"spring.datasource.");
    }

    @Bean
    public DataSource dataSource(){

        DruidDataSource dataSource = new DruidDataSource();

        dataSource.setDriverClassName(this.properties.getProperty("driverClassName"));
        dataSource.setUrl(this.properties.getProperty("url"));
        dataSource.setUsername(this.properties.getProperty("username"));
        dataSource.setPassword(this.properties.getProperty("password"));
        dataSource.setInitialSize(Integer.valueOf(this.properties.getProperty("initialSize")));
        dataSource.setMinIdle(Integer.valueOf(this.properties.getProperty("minIdle")));
        dataSource.setMaxActive(Integer.valueOf(this.properties.getProperty("maxActive")));
        dataSource.setMaxWait(Long.valueOf(this.properties.getProperty("maxWait")));
        dataSource.setTimeBetweenEvictionRunsMillis(Long.valueOf(this.properties.getProperty("timeBetweenEvictionRunsMillis")));
        dataSource.setMinEvictableIdleTimeMillis(Long.valueOf(this.properties.getProperty("minEvictableIdleTimeMillis")));
        dataSource.setValidationQuery(this.properties.getProperty("validationQuery"));
        dataSource.setTestWhileIdle(Boolean.valueOf(this.properties.getProperty("testWhileIdle")));
        dataSource.setTestOnBorrow(Boolean.valueOf(this.properties.getProperty("testOnBorrow")));
        dataSource.setTestOnReturn(Boolean.valueOf(this.properties.getProperty("testOnReturn")));
        dataSource.setPoolPreparedStatements(Boolean.valueOf(this.properties.getProperty("poolPreparedStatements")));
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(Integer.valueOf(this.properties.getProperty("maxPoolPreparedStatementPerConnectionSize")));
        dataSource.setRemoveAbandonedTimeoutMillis(Long.valueOf(this.properties.getProperty("removeAbandonedTimeoutMillis")));
        dataSource.setRemoveAbandoned(Boolean.valueOf(this.properties.getProperty("removeAbandoned")));
        dataSource.setLogDifferentThread(Boolean.valueOf(this.properties.getProperty("logDifferentThread")));

        return dataSource;
    }

}

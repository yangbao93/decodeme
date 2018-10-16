package com.azuray.decodeme.config;

import javax.sql.DataSource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;

@Configuration
// @MapperScan("com.baomidou.springboot.mapper*")//这个注解，作用相当于下面的@Bean
// MapperScannerConfigurer，2者配置1份即可
public class MybatisPlusConfig {

    /**
     * mybatis-plus分页插件<br>
     * 文档：http://mp.baomidou.com<br>
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setDialectType("mysql");
        return paginationInterceptor;
    }

    /**
     * 相当于顶部的： {@code @MapperScan("com.baomidou.springboot.mapper*")} 这里可以扩展，比如使用配置文件来配置扫描Mapper的路径
     */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
        scannerConfigurer.setBasePackage("com.azuray.decodeme.mapper*");
        return scannerConfigurer;
    }

    /**
     * 因为springboot2.0开始不支持druid数据库连接池，所以需要引入druid-starter进行数据库连接池的配置
     * @return
     */
    @Bean(name = "dataSource")
    public DataSource dataSource() {
        return DruidDataSourceBuilder.create().build();
    }
}

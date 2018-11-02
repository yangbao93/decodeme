package com.azuray.decodeme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
// 开启扫描controller，service，mapper
@ComponentScan(basePackages = {"com.azuray.decodeme.*"})
// 开启扫描xml
//@ImportResource(locations = {"classpath:/applicationContext.xml"})
// 开启事务
//@EnableTransactionManagement
@EnableScheduling
public class DecodeMeApplication {

    public static void main(String[] args) {
        SpringApplication.run(DecodeMeApplication.class, args);
    }
}

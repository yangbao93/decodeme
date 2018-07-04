package com.azuray.decodeme;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
public class DecodemeApplication {

    public static void main(String[] args) {
        SpringApplication.run(DecodemeApplication.class, args);
    }
}

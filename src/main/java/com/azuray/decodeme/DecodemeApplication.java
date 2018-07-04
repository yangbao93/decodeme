package com.azuray.decodeme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.azuray.decodeme.dao"})
public class DecodemeApplication {

  public static void main(String[] args) {
    SpringApplication.run(DecodemeApplication.class, args);
  }
}

package com.azuray.decodeme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ComponentScan(basePackages = {"com.azuray.decodeme.mapper*","com.azuray.decodeme.controller","com.azuray.decodeme.service"})
@ImportResource(locations = {"classpath:/applicationContext.xml"})
public class DecodemeApplication {

  public static void main(String[] args) {
    SpringApplication.run(DecodemeApplication.class, args);
  }
}

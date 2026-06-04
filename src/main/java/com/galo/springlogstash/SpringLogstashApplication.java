package com.galo.springlogstash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SpringLogstashApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringLogstashApplication.class, args);
  }

}

package com.compfest.sea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("com.compfest.sea.entity")
@SpringBootApplication
public class SeastoreApplication {

  public static void main(String[] args) {
    SpringApplication.run(SeastoreApplication.class, args);
  }
}

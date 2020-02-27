package org.springbootcamp.bannerama.test.example;

import org.springbootcamp.bannerama.Bannerama;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExampleApp {

  public static void main(String[] args) {
    SpringApplication app = new SpringApplication(ExampleApp.class);
    app.setBanner(Bannerama.builder()
      .title("The spring boot banner example app")
      .additionalVersion("Camunda Version", "7.12.0-ee")
      .build());

    app.run(args);
  }
}

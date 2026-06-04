package com.galo.springlogstash;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HelloController {

  private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

  @GetMapping("/hello")
  public String hello() {
    logger.info("Endpoint /hello foi chamado");
    return "Hello World!";
  }

  @GetMapping("/error")
  public String error() {
    logger.error("Simulando um erro para log");
    return "Erro simulado!";
  }
}

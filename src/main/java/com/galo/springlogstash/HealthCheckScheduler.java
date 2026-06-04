package com.galo.springlogstash;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HealthCheckScheduler {

  private static final Logger logger = LoggerFactory.getLogger(HealthCheckScheduler.class);
  private final RestTemplate restTemplate = new RestTemplate();

  @Scheduled(fixedRate = 10000) // a cada 10 segundos
  public void checkMainAppHealth() {
    try {
      String response = restTemplate.getForObject("http://localhost:8484/actuator/health", String.class);
      logger.info("Main App Health: {}", response);
    } catch (Exception e) {
      logger.error("Erro ao chamar /actuator/health: {}", e.getMessage());
    }
  }

  @Scheduled(fixedRate = 15000) // a cada 15 segundos
  public void checkOtherAppHealth() {
    try {
      String response = restTemplate.getForObject("http://localhost:8484/actuator/health", String.class);
      logger.info("Other App Health: {}", response);
    } catch (Exception e) {
      logger.error("Erro ao chamar outra app /actuator/health: {}", e.getMessage());
    }
  }
}

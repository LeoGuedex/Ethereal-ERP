package leoguedex.com.github.HealthCoachWeb.config;

import leoguedex.com.github.HealthCoachWeb.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("local")
public class TestConfig {

  @Autowired
  private DBService dbService;

  @Bean
  public boolean instantiateDatabase() {
    dbService.createTestCustomer();
    dbService.createLoginAdmin();

    return true;
  }

}

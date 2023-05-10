package leoguedex.com.github.HealthCoachWeb.config;

import leoguedex.com.github.HealthCoachWeb.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DBService dbService;

    @Bean
    public boolean instantiateDatabase() throws ParseException {
        dbService.createTestCustomer();
        dbService.createLoginAdmin();
        return true;
    }

}

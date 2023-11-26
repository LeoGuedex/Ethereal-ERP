package leoguedex.com.github.EtherealERP.config;

import leoguedex.com.github.EtherealERP.service.DBService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("local")
public class TestConfig {

    private final DBService dbService;

    public TestConfig(DBService dbService) {
        this.dbService = dbService;
    }

    @Bean
    public boolean instantiateDatabase() {
        dbService.createTestCustomer();
        dbService.createLoginAdmin();

        return true;
    }

}

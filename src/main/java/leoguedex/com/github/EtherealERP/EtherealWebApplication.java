package leoguedex.com.github.EtherealERP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class EtherealWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(EtherealWebApplication.class, args);
    }

}

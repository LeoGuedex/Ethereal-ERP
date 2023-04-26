package leoguedex.com.github.HealthCoachWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class HealthCoachWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthCoachWebApplication.class, args);
	}

}

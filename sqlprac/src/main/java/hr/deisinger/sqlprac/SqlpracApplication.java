package hr.deisinger.sqlprac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SqlpracApplication {

	public static void main(String[] args) {
		SpringApplication.run(SqlpracApplication.class, args);
	}

}

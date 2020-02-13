package ca.rcherara.services.config.configservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigServiceApplication {

	public static void main(final String[] args) {
		SpringApplication.run(ConfigServiceApplication.class, args);
	}

}

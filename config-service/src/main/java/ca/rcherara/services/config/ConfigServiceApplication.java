package ca.rcherara.services.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableConfigServer
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@EnableEurekaClient
public class ConfigServiceApplication {

	public static void main(final String[] args) {
		SpringApplication.run(ConfigServiceApplication.class, args);
	}

}

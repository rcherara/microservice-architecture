package ca.rcherara.services.vehicle.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.Lists;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .servers(Lists.newArrayList(
                        new Server().url("http://localhost:8081"),
                        new Server().url("https://api.rcherara.me")
                ))
                // info
                .info(new Info().title("Vehicle Application API")
                                .description("Vehicle OpenAPI 3.0")
                                .contact(new Contact()
                                                 .email("cherara.reddah@icloud.com")
                                                 .name("CHERARA REDDAH")
                                                 .url("https://rcherara.ca/"))
                                .license(new License()
                                                 .name("Apache 2.0")
                                                 .url("http://www.apache.org/licenses/LICENSE-2.0.html"))
                                .version("1.0.0"));
    }
}
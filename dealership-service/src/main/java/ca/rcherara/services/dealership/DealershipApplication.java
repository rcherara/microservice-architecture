package ca.rcherara.services.dealership;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import ca.rcherara.services.dealership.config.SpringApplicationContextInitializer;
import ca.rcherara.services.dealership.repositories.DealershipRepositoryPopulator;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DealershipApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(DealershipApplication.class)
                .initializers(new SpringApplicationContextInitializer())
                .listeners(new DealershipRepositoryPopulator())
                .application()
                .run(args);
    }
}

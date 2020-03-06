package ca.rcherara.services.vehicle.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class Swagger2Config {

/*     @Bean
    public Docket springfoxAppInfo() {
        return new Docket(DocumentationType.SWAGGER_2)
          .groupName("vehicle-api")
          .select()
          .paths(paths())
          .build();
          .apiInfo(apiInfo());
    }
 */
    private Predicate<String> paths() {
        return regex("/api/.*");       
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
          "Vehicle API specification", 
          "Vehicle Spring REST API", 
          "", 
          "", 
          null, 
          "License of API",
          "API license URL", 
          Collections.emptyList());
    }

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("ca.rcherara.services.vehicle.controller"))
               // .paths(PathSelectors.any())
                 .paths(paths())
                .build()
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
    }

/*     private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Vehicle API specification")
                .description("Vehicle Service Project")
                .version("1.0")
                .build();
    } */

    private List<ApiKey> securitySchemes() {

        List<ApiKey> result = new ArrayList<>();
        ApiKey apiKey = new ApiKey("Authorization", "Authorization", "header");
        result.add(apiKey);
        return result;
    }

    private List<SecurityContext> securityContexts() {
        List<SecurityContext> result = new ArrayList<>();
        result.add(getContextByPath("/api/.*"));
        result.add(getContextByPath("/vehicles/.*"));
        result.add(getContextByPath("/vehicle/.*"));
        return result;
    }

    private SecurityContext getContextByPath(String pathRegex){
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex(pathRegex))
                .build();
    }

    private List<SecurityReference> defaultAuth() {
        List<SecurityReference> result = new ArrayList<>();
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        result.add(new SecurityReference("Authorization", authorizationScopes));
        return result;
    }
    
}
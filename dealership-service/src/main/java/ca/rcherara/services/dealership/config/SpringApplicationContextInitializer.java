package ca.rcherara.services.dealership.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.Profiles;
import org.springframework.core.env.PropertySource;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SpringApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    private static final Log logger = LogFactory.getLog(SpringApplicationContextInitializer.class);

    private static final Map<String, List<String>> profileNameToServiceTags = new HashMap<>();
    static {
        profileNameToServiceTags.put("mongodb", Collections.singletonList("mongodb"));
        profileNameToServiceTags.put("postgres", Collections.singletonList("postgres"));
        profileNameToServiceTags.put("mysql", Collections.singletonList("mysql"));
        profileNameToServiceTags.put("redis", Collections.singletonList("redis"));
        profileNameToServiceTags.put("oracle", Collections.singletonList("oracle"));
        profileNameToServiceTags.put("sqlserver", Collections.singletonList("sqlserver"));
    }

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        ConfigurableEnvironment appEnvironment = applicationContext.getEnvironment();

        validateActiveProfiles(appEnvironment);

        

        excludeAutoConfiguration(appEnvironment);
    }

   

    private void validateActiveProfiles(ConfigurableEnvironment appEnvironment) {
        Set<String> validLocalProfiles = profileNameToServiceTags.keySet();

        List<String> serviceProfiles = Stream.of(appEnvironment.getActiveProfiles())
                .filter(validLocalProfiles::contains)
                .collect(Collectors.toList());

        if (serviceProfiles.size() > 1) {
            throw new IllegalStateException("Only one active Spring profile may be set among the following: " +
                    validLocalProfiles.toString() + ". " +
                    "These profiles are active: [" +
                    StringUtils.collectionToCommaDelimitedString(serviceProfiles) + "]");
        }
    }

    private void excludeAutoConfiguration(ConfigurableEnvironment environment) {
        List<String> exclude = new ArrayList<>();
        if (environment.acceptsProfiles(Profiles.of("redis"))) {
            excludeDataSourceAutoConfiguration(exclude);
            excludeMongoAutoConfiguration(exclude);
        } else if (environment.acceptsProfiles(Profiles.of("mongodb"))) {
            excludeDataSourceAutoConfiguration(exclude);
            excludeRedisAutoConfiguration(exclude);
        } else {
            excludeMongoAutoConfiguration(exclude);
            excludeRedisAutoConfiguration(exclude);
        }

        Map<String, Object> properties = Collections.singletonMap("spring.autoconfigure.exclude",
                StringUtils.collectionToCommaDelimitedString(exclude));

        PropertySource<?> propertySource = new MapPropertySource("springMusicAutoConfig", properties);

        environment.getPropertySources().addFirst(propertySource);
    }

    private void excludeDataSourceAutoConfiguration(List<String> exclude) {
        exclude.add(DataSourceAutoConfiguration.class.getName());
    }

    private void excludeMongoAutoConfiguration(List<String> exclude) {
        exclude.addAll(Arrays.asList(
                MongoAutoConfiguration.class.getName(),
                MongoDataAutoConfiguration.class.getName(),
                MongoRepositoriesAutoConfiguration.class.getName()
        ));
    }

    private void excludeRedisAutoConfiguration(List<String> exclude) {
        exclude.addAll(Arrays.asList(
                RedisAutoConfiguration.class.getName(),
                RedisRepositoriesAutoConfiguration.class.getName()
        ));
    }
}

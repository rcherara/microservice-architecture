package ca.rcherara.services.dealership.config.data;

import ca.rcherara.services.dealership.domain.Dealership;
import ca.rcherara.services.dealership.repositories.redis.RedisDealershipRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@Profile("redis")
public class RedisConfig {

    @Bean
    public RedisDealershipRepository redisRepository(RedisTemplate<String, Dealership> redisTemplate) {
        return new RedisDealershipRepository(redisTemplate);
    }

    @Bean
    public RedisTemplate<String, Dealership> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Dealership> template = new RedisTemplate<>();

        template.setConnectionFactory(redisConnectionFactory);

        RedisSerializer<String> stringSerializer = new StringRedisSerializer();
        RedisSerializer<Dealership> dealershipSerializer = new Jackson2JsonRedisSerializer<>(Dealership.class);

        template.setKeySerializer(stringSerializer);
        template.setValueSerializer(dealershipSerializer);
        template.setHashKeySerializer(stringSerializer);
        template.setHashValueSerializer(dealershipSerializer);

        return template;
    }

}

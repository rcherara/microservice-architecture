package io.swag.corona.allocator.application.service;

import com.github.javafaker.Faker;
import io.swag.corona.allocator.application.port.in.MatchJobsUseCase;
import io.swag.corona.allocator.domain.JobRecommendation;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class AllocatorMockService implements MatchJobsUseCase {

    private Faker faker;

    @PostConstruct
    void init() {
        this.faker = new Faker();
    }

    @Override
    public List<JobRecommendation> match(String employeeId) {
        return IntStream.range(1, 10)
                .mapToObj(x -> new JobRecommendation(
                        faker.bothify("????-????-????-????"),
                        faker.number().numberBetween(1L, 100L),
                        faker.rickAndMorty().quote()
                ))
                .collect(Collectors.toList());

    }
}

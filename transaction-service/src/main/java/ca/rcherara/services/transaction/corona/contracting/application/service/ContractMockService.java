package io.swag.corona.contracting.application.service;

import com.github.javafaker.Faker;
import io.swag.corona.contracting.application.port.in.CreateContractUseCase;
import io.swag.corona.contracting.application.port.in.FindContractByJobUseCase;
import io.swag.corona.contracting.application.port.in.FindContractsByJobUseCase;
import io.swag.corona.contracting.application.port.in.UpdateContractUseCase;
import io.swag.corona.contracting.domain.Contract;

import javax.annotation.PostConstruct;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ContractMockService implements
        CreateContractUseCase,
        FindContractsByJobUseCase,
        FindContractByJobUseCase,
        UpdateContractUseCase {

    private Faker faker;

    @PostConstruct
    void init() {
        this.faker = new Faker();
    }

    @Override
    public Contract create(String jobId) {
        return new Contract(
                faker.bothify("????-????-????-????"),
                faker.bothify("????-????-????-????"),
                jobId,
                LocalTime.now(),
                false,
                false
        );
    }

    @Override
    public Contract findById(String jobId, String contractId) {
        return new Contract(
                contractId,
                faker.bothify("????-????-????-????"),
                jobId,
                LocalTime.now(),
                faker.bool().bool(),
                faker.bool().bool()
        );
    }

    @Override
    public List<Contract> findAll(String jobId) {
        return IntStream.range(0, 10)
                .mapToObj(x -> new Contract(
                        faker.bothify("????-????-????-????"),
                        faker.bothify("????-????-????-????"),
                        jobId,
                        LocalTime.now(),
                        faker.bool().bool(),
                        faker.bool().bool()))
                .collect(Collectors.toList());
    }

    @Override
    public Contract update(String jobId, String contractId, boolean videoVerified, boolean signed) {
        return new Contract(
                contractId,
                faker.bothify("????-????-????-????"),
                jobId,
                LocalTime.now(),
                videoVerified,
                signed
        );
    }
}

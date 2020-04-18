package io.swag.corona.contracting.adapter.out.postgres;

import io.swag.corona.contracting.application.port.out.FindContractByIdPort;
import io.swag.corona.contracting.application.port.out.FindContractsByJobPort;
import io.swag.corona.contracting.application.port.out.SaveContractPort;
import io.swag.corona.contracting.domain.Contract;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ContractPostgresAdapter implements
        SaveContractPort,
        FindContractByIdPort,
        FindContractsByJobPort
{

    private final ContractJPARepository repository;

    @Override
    public Contract save(Contract contract) {
        return repository.save(ContractJPA.of(contract)).toDomain();
    }

    @Override
    public Contract findById(String contractId, String jobId) {
        return repository.findById(contractId).map(ContractJPA::toDomain).orElse(null);
    }

    @Override
    public List<Contract> findByJobId(String jobId) {
        return repository.findAllByJobId(jobId).stream().map(ContractJPA::toDomain).collect(Collectors.toList());
    }
}

package io.swag.corona.employer.adapter.out.postgres;

import io.swag.corona.employer.application.port.out.GetEmployerIdByAccountIdPort;
import io.swag.corona.employer.application.port.out.GetEmployerPort;
import io.swag.corona.employer.application.port.out.SaveEmployerPort;
import io.swag.corona.employer.domain.Employer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployerPostgresAdapter implements
        SaveEmployerPort,
        GetEmployerIdByAccountIdPort,
        GetEmployerPort {

    private final EmployerJPARepository repository;

    @Override
    public Employer save(Employer employer, String accountId) {

        // Domain -> JPA
        EmployerJPA recordToBeSaved = EmployerJPA.of(employer, accountId);

        // Magic
        EmployerJPA recordSaved = repository.save(recordToBeSaved);

        // JPA -> Domain
        Employer recordAsDomainObject = recordSaved.toDomain();

        return recordAsDomainObject;

    }

    @Override
    public Employer getById(String id) {
        return repository.findById(id).map(EmployerJPA::toDomain).orElse(null);
    }

    @Override
    public String findByAccountId(String accountId) {
        return repository.findByAccountId(accountId).map(employerJPA -> employerJPA.id).orElse(null);
    }
}

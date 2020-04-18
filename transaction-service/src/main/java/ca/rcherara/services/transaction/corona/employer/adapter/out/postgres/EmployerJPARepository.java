package io.swag.corona.employer.adapter.out.postgres;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface EmployerJPARepository extends JpaRepository<EmployerJPA, String> {
    Optional<EmployerJPA> findByAccountId(String accountId);
}

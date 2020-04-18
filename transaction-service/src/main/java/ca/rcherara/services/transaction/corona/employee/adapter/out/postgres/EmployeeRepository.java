package io.swag.corona.employee.adapter.out.postgres;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<EmployeeJPA, String> {

    Optional<EmployeeJPA> findByAccountId(String accountId);
}

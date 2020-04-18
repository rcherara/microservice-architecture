package io.swag.corona.employer.adapter.out.postgres;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface JobJPARepository extends JpaRepository<JobJPA, String> {
}

package io.swag.corona.contracting.adapter.out.postgres;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContractJPARepository extends JpaRepository<ContractJPA, String> {

    List<ContractJPA> findAllByJobId(String jobId);
}

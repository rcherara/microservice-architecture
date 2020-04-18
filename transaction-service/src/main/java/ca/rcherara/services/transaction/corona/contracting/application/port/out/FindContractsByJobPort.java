package io.swag.corona.contracting.application.port.out;

import io.swag.corona.contracting.domain.Contract;

import java.util.List;

public interface FindContractsByJobPort {

    List<Contract> findByJobId(String jobId);
}

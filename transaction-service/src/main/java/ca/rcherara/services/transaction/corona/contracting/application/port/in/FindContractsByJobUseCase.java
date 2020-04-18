package io.swag.corona.contracting.application.port.in;

import io.swag.corona.contracting.domain.Contract;

import java.util.List;

public interface FindContractsByJobUseCase {

    List<Contract> findAll(String jobId);
}

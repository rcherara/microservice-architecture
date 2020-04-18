package io.swag.corona.contracting.application.port.in;

import io.swag.corona.contracting.domain.Contract;

public interface FindContractByJobUseCase {

    Contract findById(String jobId, String contractId);
}

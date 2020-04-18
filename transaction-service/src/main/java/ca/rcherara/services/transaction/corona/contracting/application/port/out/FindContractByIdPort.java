package io.swag.corona.contracting.application.port.out;

import io.swag.corona.contracting.domain.Contract;

public interface FindContractByIdPort {

    Contract findById(String contractId, String jobId);

}

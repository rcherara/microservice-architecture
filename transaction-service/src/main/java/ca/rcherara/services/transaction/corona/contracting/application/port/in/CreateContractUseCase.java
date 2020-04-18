package io.swag.corona.contracting.application.port.in;

import io.swag.corona.contracting.domain.Contract;

public interface CreateContractUseCase {

    Contract create(String jobId);

}

package io.swag.corona.contracting.application.port.in;

import io.swag.corona.contracting.domain.Contract;

public interface UpdateContractUseCase {

    Contract update(String jobId, String contractId, boolean videoVerified, boolean signed);

}

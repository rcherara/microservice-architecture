package io.swag.corona.employer.application.port.in;

import io.swag.corona.employer.domain.Job;

public interface GetJobUseCase {

    Job findById(String id);

}

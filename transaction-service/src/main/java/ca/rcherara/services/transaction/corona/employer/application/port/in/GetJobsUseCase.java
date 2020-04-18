package io.swag.corona.employer.application.port.in;

import io.swag.corona.employer.domain.Job;

import java.util.List;

public interface GetJobsUseCase {

    List<Job> findAll();

}

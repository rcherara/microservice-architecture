package io.swag.corona.employer.application.port.out;

import io.swag.corona.employer.domain.Job;

import java.util.List;

public interface GetJobsPort {

    List<Job> findAll();

}

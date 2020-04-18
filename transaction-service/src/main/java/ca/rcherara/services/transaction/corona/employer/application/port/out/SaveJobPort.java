package io.swag.corona.employer.application.port.out;

import io.swag.corona.employer.domain.Job;

public interface SaveJobPort {
    Job save(Job job);
}

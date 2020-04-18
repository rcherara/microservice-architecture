package io.swag.corona.employer.application.port.in;

import io.swag.corona.employer.domain.Job;

public interface CreateJobUseCase {

    Job create(String title, String description, String location, Long qty, Long salary, boolean germanSkill, boolean englishSkill, boolean licenseSkill, boolean studentSkill);
}

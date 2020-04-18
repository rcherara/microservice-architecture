package io.swag.corona.employer.application.port.in;

import io.swag.corona.employer.domain.Employer;

public interface CreateEmployerUseCase {

    Employer create(String name, String domain, String homepage);

}

package io.swag.corona.employer.application.port.in;

import io.swag.corona.employer.domain.Employer;

public interface UpdateEmployerUseCase {

    Employer update(String id, String name, String domain, String homepage);
}

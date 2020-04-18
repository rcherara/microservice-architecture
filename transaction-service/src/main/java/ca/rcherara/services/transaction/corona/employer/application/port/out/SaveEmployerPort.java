package io.swag.corona.employer.application.port.out;

import io.swag.corona.employer.domain.Employer;

public interface SaveEmployerPort {

    Employer save(Employer employer, String accountId);

}

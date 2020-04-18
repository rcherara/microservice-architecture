package io.swag.corona.employer.application.port.out;

public interface GetEmployerIdByAccountIdPort {

    String findByAccountId(String accountId);
}

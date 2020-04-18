package io.swag.corona.employee.application.port.out;

public interface GetEmployeeIdByAccountIdPort {

    String findByAccountId(String accountId);
}

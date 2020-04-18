package io.swag.corona.employee.application.port.in;

import io.swag.corona.employee.domain.Employee;

public interface GetCurrentEmployeeUseCase {
    Employee currentEmployee();
}

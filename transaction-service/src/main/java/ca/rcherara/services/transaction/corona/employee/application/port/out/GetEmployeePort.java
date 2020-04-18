package io.swag.corona.employee.application.port.out;

import io.swag.corona.employee.domain.Employee;

public interface GetEmployeePort {

    Employee getById(String id);

}

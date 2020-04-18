package io.swag.corona.employee.application.port.out;

import io.swag.corona.employee.domain.Employee;

public interface SaveEmployeePort {

    Employee save(Employee employee, String accountId);
}

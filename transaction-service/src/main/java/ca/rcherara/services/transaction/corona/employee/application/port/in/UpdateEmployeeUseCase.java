package io.swag.corona.employee.application.port.in;

import io.swag.corona.employee.domain.Employee;

public interface UpdateEmployeeUseCase {

    Employee updateEmployee(String id, String name, String ageGroup, String location, boolean germanSkill, boolean englishSkill, boolean licenseSkill, boolean studentSkill);

}

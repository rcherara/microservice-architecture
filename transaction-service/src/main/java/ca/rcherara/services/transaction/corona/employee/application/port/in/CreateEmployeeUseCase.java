package io.swag.corona.employee.application.port.in;

import io.swag.corona.employee.domain.Employee;

public interface CreateEmployeeUseCase {

    Employee create(String name, String ageGroup, String location, boolean germanSkill, boolean englishSkill, boolean licenseSkill, boolean studentSkill);

}

package io.swag.corona.employee.adapter.out.postgres;

import io.swag.corona.employee.application.port.out.DeleteEmployeePort;
import io.swag.corona.employee.application.port.out.GetEmployeeIdByAccountIdPort;
import io.swag.corona.employee.application.port.out.GetEmployeePort;
import io.swag.corona.employee.application.port.out.SaveEmployeePort;
import io.swag.corona.employee.domain.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeePostgresAdapter implements
        SaveEmployeePort,
        DeleteEmployeePort,
        GetEmployeePort,
        GetEmployeeIdByAccountIdPort
{

    private final EmployeeRepository repository;

    @Override
    public Employee save(Employee employee, String accountId) {
        return repository.save(EmployeeJPA.of(employee, accountId)).toDomain();
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    @Override
    public Employee getById(String id) {
        return repository.findById(id).map(EmployeeJPA::toDomain).orElse(null);
    }

    @Override
    public String findByAccountId(String accountId) {
        return repository.findByAccountId(accountId).map(EmployeeJPA::toDomain).map(Employee::getId).orElse("-1");
    }

}

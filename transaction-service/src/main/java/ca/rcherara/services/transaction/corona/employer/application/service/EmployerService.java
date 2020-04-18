package io.swag.corona.employer.application.service;

import io.swag.corona.account.application.port.in.FetchActiveAccountUseCase;
import io.swag.corona.employer.application.port.in.*;
import io.swag.corona.employer.application.port.out.GetEmployerIdByAccountIdPort;
import io.swag.corona.employer.application.port.out.GetEmployerPort;
import io.swag.corona.employer.application.port.out.SaveEmployerPort;
import io.swag.corona.employer.domain.Employer;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
@RequiredArgsConstructor
public class EmployerService implements
        CreateEmployerUseCase,
        GetCurrentEmployerUseCase,
        GetActiveEmployerIdUseCase,
        GetEmployerUseCase,
        UpdateEmployerUseCase {

    private final FetchActiveAccountUseCase fetchActiveAccountUseCase;
    private final SaveEmployerPort saveEmployerPort;
    private final GetEmployerIdByAccountIdPort getEmployerIdByAccountIdPort;
    private final GetEmployerPort getEmployerPort;

    @Override
    public Employer create(String name, String domain, String homepage) {
        var accountId = fetchActiveAccountUseCase.activeAccount().getId();
        return saveEmployerPort.save(new Employer("", name, domain, homepage), accountId);
    }

    @Override
    public Employer getById(String employerId) {
        return getEmployerPort.getById(employerId);
    }

    @Override
    public Employer update(String id, String name, String domain, String homepage) {
        var accountId = fetchActiveAccountUseCase.activeAccount().getId();
        return saveEmployerPort.save(new Employer(id, name, domain, homepage), accountId);
    }

    @Override
    public String getActiveEmployerId() {
        var activeAccountId = fetchActiveAccountUseCase.activeAccount().getId();
        return getEmployerIdByAccountIdPort.findByAccountId(activeAccountId);
    }

    @Override
    public Employer currentEmployer() {
        var employeeId = getActiveEmployerId();
        if (employeeId != null) {
            return getEmployerPort.getById(employeeId);
        }
        return null;
    }
}

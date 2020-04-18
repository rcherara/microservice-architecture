package io.swag.corona.contracting.application.service;

import io.swag.corona.contracting.application.port.in.CreateContractUseCase;
import io.swag.corona.contracting.application.port.in.FindContractByJobUseCase;
import io.swag.corona.contracting.application.port.in.FindContractsByJobUseCase;
import io.swag.corona.contracting.application.port.in.UpdateContractUseCase;
import io.swag.corona.contracting.application.port.out.FindContractByIdPort;
import io.swag.corona.contracting.application.port.out.FindContractsByJobPort;
import io.swag.corona.contracting.application.port.out.SaveContractPort;
import io.swag.corona.contracting.domain.Contract;
import io.swag.corona.employee.application.port.in.GetActiveEmployeeIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.List;

@Primary
@Component
@RequiredArgsConstructor
public class ContractService implements
        CreateContractUseCase,
        FindContractByJobUseCase,
        FindContractsByJobUseCase,
        UpdateContractUseCase
{

    private final SaveContractPort saveContractPort;
    private final GetActiveEmployeeIdUseCase getActiveEmployeeIdUseCase;
    private final FindContractByIdPort findContractByIdPort;
    private final FindContractsByJobPort findContractsByJobPort;

    @Override
    public Contract create(String jobId) {
        var activeEmployeeId = getActiveEmployeeIdUseCase.getActiveEmployeeId();
        return saveContractPort.save(new Contract(null, activeEmployeeId, jobId, LocalTime.now(), false, false));
    }

    @Override
    public Contract findById(String jobId, String contractId) {
        return findContractByIdPort.findById(contractId, jobId);
    }

    @Override
    public List<Contract> findAll(String jobId) {
        return findContractsByJobPort.findByJobId(jobId);
    }

    @Override
    public Contract update(String jobId, String contractId, boolean videoVerified, boolean signed) {
        var activeEmployeeId = getActiveEmployeeIdUseCase.getActiveEmployeeId();
        return saveContractPort.save(new Contract(contractId, activeEmployeeId, jobId, LocalTime.now(), videoVerified, signed));    }
}

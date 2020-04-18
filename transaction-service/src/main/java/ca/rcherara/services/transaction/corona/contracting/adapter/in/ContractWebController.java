package io.swag.corona.contracting.adapter.in;

import io.swag.corona.contracting.application.port.in.CreateContractUseCase;
import io.swag.corona.contracting.application.port.in.FindContractByJobUseCase;
import io.swag.corona.contracting.application.port.in.FindContractsByJobUseCase;
import io.swag.corona.contracting.application.port.in.UpdateContractUseCase;
import io.swag.corona.contracting.domain.Contract;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ContractWebController {

    private final CreateContractUseCase createContractUseCase;
    private final FindContractByJobUseCase findContractByJobUseCase;
    private final FindContractsByJobUseCase findContractsByJobUseCase;
    private final UpdateContractUseCase updateContractUseCase;

    @RequestMapping(path = "/job/{jobId}/contract", method = RequestMethod.POST)
    public Contract create(@PathVariable("jobId") String jobId) {
        return createContractUseCase.create(jobId);
    }

    @RequestMapping(path = "/job/{jobId}/contract", method = RequestMethod.GET)
    public List<Contract> findAll(@PathVariable("jobId") String jobId) {
        return findContractsByJobUseCase.findAll(jobId);
    }

    @RequestMapping(path = "/job/{jobId}/contract/{contractId}", method = RequestMethod.GET)
    public Contract findById(
            @PathVariable("jobId") String jobId,
            @PathVariable("contractId") String contractId) {
        return findContractByJobUseCase.findById(jobId, contractId);
    }

    @RequestMapping(path = "/job/{jobId}/contract/{contractId}", method = RequestMethod.PUT)
    public Contract update(
            @PathVariable("jobId") String jobId,
            @PathVariable("contractId") String contractId,
            @RequestParam("signed") boolean signed,
            @RequestParam("videoVerified") boolean videoVerified
    ) {
        return updateContractUseCase.update(jobId, contractId, signed, videoVerified);
    }
}

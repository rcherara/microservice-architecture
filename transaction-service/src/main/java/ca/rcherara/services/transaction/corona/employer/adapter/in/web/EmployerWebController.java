package io.swag.corona.employer.adapter.in.web;

import io.swag.corona.employer.application.port.in.CreateEmployerUseCase;
import io.swag.corona.employer.application.port.in.GetCurrentEmployerUseCase;
import io.swag.corona.employer.application.port.in.GetEmployerUseCase;
import io.swag.corona.employer.application.port.in.UpdateEmployerUseCase;
import io.swag.corona.employer.domain.Employer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class EmployerWebController {

    private final CreateEmployerUseCase createEmployerUseCase;
    private final GetEmployerUseCase getEmployerUseCase;
    private final GetCurrentEmployerUseCase getCurrentEmployerUseCase;
    private final UpdateEmployerUseCase updateEmployerUseCase;

    @RequestMapping(path = "/employer", method = RequestMethod.POST)
    public Employer create(
            @RequestParam("name") String name,
            @RequestParam("domain") String domain,
            @RequestParam("homepage") String homepage) {
        return createEmployerUseCase.create(name, domain, homepage);
    }

    @RequestMapping(path = "/employer/{id}", method = RequestMethod.GET)
    public Employer getById(@PathVariable("id") String id) {
        return getEmployerUseCase.getById(id);
    }

    @RequestMapping(path = "/employer/me", method = RequestMethod.GET)
    public Employer getCurrent() {
        return getCurrentEmployerUseCase.currentEmployer();
    }

    @RequestMapping(path = "/employer/{id}", method = RequestMethod.PUT)
    public Employer update(
            @PathVariable("id") String id,
            @RequestParam("name") String name,
            @RequestParam("domain") String domain,
            @RequestParam("homepage") String homepage) {
        return updateEmployerUseCase.update(id, name, domain, homepage);
    }
}

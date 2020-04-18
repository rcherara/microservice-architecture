package io.swag.corona.employee.adapter.in;

import io.swag.corona.employee.application.port.in.*;
import io.swag.corona.employee.domain.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class EmployeeWebController {

    private final CreateEmployeeUseCase createEmployeeUseCase;
    private final DeleteEmployeeUseCase deleteEmployeeUseCase;
    private final GetEmployeeUseCase getEmployeeUseCase;
    private final UpdateEmployeeUseCase updateEmployeeUseCase;
    private final GetCurrentEmployeeUseCase getCurrentEmployeeUseCase;

    @RequestMapping(path = "/employee", method = RequestMethod.POST)
    public Employee create(
            @RequestParam("name") String name,
            @RequestParam("ageGroup") String ageGroup,
            @RequestParam("location") String location,
            @RequestParam("germanSkill") boolean germanSkill,
            @RequestParam("englishSkill") boolean englishSkill,
            @RequestParam("licenseSkill") boolean licenseSkill,
            @RequestParam("studentSkill") boolean studentSkill
    ) {
        return createEmployeeUseCase.create(name, ageGroup, location, germanSkill, englishSkill, licenseSkill, studentSkill);
    }

    @RequestMapping(path = "/employee/me", method = RequestMethod.GET)
    public Employee getCurrent() {
        return getCurrentEmployeeUseCase.currentEmployee();
    }

    @RequestMapping(path = "/employee/{id}", method = RequestMethod.GET)
    public Employee getById(@PathVariable("id") String id) {
        return getEmployeeUseCase.getById(id);
    }


    @RequestMapping(path = "/employee/{id}", method = RequestMethod.PUT)
    public Employee update(
            @PathVariable("id") String id,
            @RequestParam("name") String name,
            @RequestParam("ageGroup") String ageGroup,
            @RequestParam("location") String location,
            @RequestParam("germanSkill") boolean germanSkill,
            @RequestParam("englishSkill") boolean englishSkill,
            @RequestParam("licenseSkill") boolean licenseSkill,
            @RequestParam("studentSkill") boolean studentSkill
    ) {
        return updateEmployeeUseCase.updateEmployee(id, name, ageGroup, location, germanSkill, englishSkill, licenseSkill, studentSkill);
    }

    @RequestMapping(path = "/employee/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable("id") String id) {
        deleteEmployeeUseCase.deleteById(id);
    }

}

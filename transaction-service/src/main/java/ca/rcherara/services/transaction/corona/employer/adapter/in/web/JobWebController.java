package io.swag.corona.employer.adapter.in.web;

import io.swag.corona.employer.application.port.in.*;
import io.swag.corona.employer.domain.Job;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class JobWebController {

    private final CreateJobUseCase createJobUseCase;
    private final DeleteJobUseCase deleteJobUseCase;
    private final GetJobsUseCase getJobsUseCase;
    private final GetJobUseCase getJobUseCase;
    private final UpdateJobUseCase updateJobUseCase;

    @RequestMapping(path = "/job", method = RequestMethod.POST)
    public Job create(
            @RequestParam("descr") String description,
            @RequestParam("title") String title,
            @RequestParam("location") String location,
            @RequestParam("qty") Long qty,
            @RequestParam("salary") Long salary,
            @RequestParam("germanSkill") boolean germanSkill,
            @RequestParam("englishSkill") boolean englishSkill,
            @RequestParam("licenseSkill") boolean licenseSkill,
            @RequestParam("studentSkill") boolean studentSkill
    ) {
        return createJobUseCase.create(
                title,
                description,
                location,
                qty,
                salary,
                germanSkill, englishSkill, licenseSkill, studentSkill
        );
    }

    @RequestMapping(path = "/job", method = RequestMethod.GET)
    public List<Job> findAll() {
        return getJobsUseCase.findAll();
    }

    @RequestMapping(path = "/job/{id}", method = RequestMethod.GET)
    public Job findById(@PathVariable("id") String id) {
        return getJobUseCase.findById(id);
    }

    @RequestMapping(path = "/job/{id}", method = RequestMethod.PUT)
    public Job update(
            @PathVariable("id") String id,
            @RequestParam("title") String title,
            @RequestParam("descr") String description,
            @RequestParam("location") String location,
            @RequestParam("qty") Long qty,
            @RequestParam("salary") Long salary,
            @RequestParam("germanSkill") boolean germanSkill,
            @RequestParam("englishSkill") boolean englishSkill,
            @RequestParam("licenseSkill") boolean licenseSkill,
            @RequestParam("studentSkill") boolean studentSkill
    ) {
        return updateJobUseCase.update(
                id,
                title,
                description,
                location,
                qty,
                salary,
                germanSkill, englishSkill, licenseSkill, studentSkill
        );
    }

    @RequestMapping(path = "/job/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") String jobId) {
        deleteJobUseCase.delete(jobId);
    }
}

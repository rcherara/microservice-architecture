package io.swag.corona.employer.application.service;

import io.swag.corona.employer.application.port.in.*;
import io.swag.corona.employer.application.port.out.DeleteJobPort;
import io.swag.corona.employer.application.port.out.GetJobPort;
import io.swag.corona.employer.application.port.out.GetJobsPort;
import io.swag.corona.employer.application.port.out.SaveJobPort;
import io.swag.corona.employer.domain.Job;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

@Primary
@Component
@RequiredArgsConstructor
public class JobService implements
        CreateJobUseCase,
        DeleteJobUseCase,
        GetJobUseCase,
        GetJobsUseCase,
        UpdateJobUseCase {
    private final SaveJobPort saveJobPort;
    private final DeleteJobPort deleteJobPort;
    private final GetJobPort getJobPort;
    private final GetJobsPort getJobsPort;

    @Override
    public Job create(String title, String description, String location, Long qty, Long salary, boolean germanSkill, boolean englishSkill, boolean licenseSkill, boolean studentSkill) {
        return saveJobPort.save(new Job("", title, description, location, qty, salary, germanSkill, englishSkill, licenseSkill, studentSkill));
    }

    @Override
    public void delete(String jobId) {
        deleteJobPort.delete(jobId);
    }

    @Override
    public Job findById(String id) {
        return getJobPort.getById(id);
    }

    @Override
    public List<Job> findAll() {
        return getJobsPort.findAll();
    }

    @Override
    public Job update(String id, String title, String description, String location, Long qty, Long salary, boolean germanSkill, boolean englishSkill, boolean licenseSkill, boolean studentSkill) {
        return saveJobPort.save(new Job(id, title, description, location, qty, salary, germanSkill, englishSkill, licenseSkill, studentSkill));
    }
}

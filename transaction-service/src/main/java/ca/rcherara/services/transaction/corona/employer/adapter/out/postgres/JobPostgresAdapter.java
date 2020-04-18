package io.swag.corona.employer.adapter.out.postgres;

import io.swag.corona.employer.application.port.out.DeleteJobPort;
import io.swag.corona.employer.application.port.out.GetJobPort;
import io.swag.corona.employer.application.port.out.GetJobsPort;
import io.swag.corona.employer.application.port.out.SaveJobPort;
import io.swag.corona.employer.domain.Job;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class JobPostgresAdapter implements
        SaveJobPort,
        DeleteJobPort,
        GetJobPort,
        GetJobsPort
{

    private final JobJPARepository repository;

    @Override
    public Job save(Job job) {
        return repository.save(JobJPA.of(job)).toDomain();
    }

    @Override
    public void delete(String jobId) {
        repository.deleteById(jobId);
    }

    @Override
    public Job getById(String jobId) {
        return repository.findById(jobId).map(JobJPA::toDomain).orElse(null);
    }

    @Override
    public List<Job> findAll() {
        return repository.findAll().stream().map(JobJPA::toDomain).collect(Collectors.toList());
    }
}

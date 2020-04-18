package io.swag.corona.allocator.application.port.in;

import io.swag.corona.allocator.domain.JobRecommendation;

import java.util.List;

public interface MatchJobsUseCase {

    List<JobRecommendation> match(String employeeId);
}

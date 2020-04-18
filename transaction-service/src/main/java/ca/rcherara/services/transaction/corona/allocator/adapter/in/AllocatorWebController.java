package io.swag.corona.allocator.adapter.in;

import io.swag.corona.allocator.application.port.in.MatchJobsUseCase;
import io.swag.corona.allocator.domain.JobRecommendation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AllocatorWebController  {

    private final MatchJobsUseCase matchJobsUseCase;

    @RequestMapping(path = "/matches", method = RequestMethod.GET)
    public List<JobRecommendation> findMatchesById(@RequestParam("id") String employeeId) {
        return matchJobsUseCase.match(employeeId);
    }

}

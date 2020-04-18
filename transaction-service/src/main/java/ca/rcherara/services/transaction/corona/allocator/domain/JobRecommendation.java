package io.swag.corona.allocator.domain;

import lombok.Value;

@Value
public class JobRecommendation {
    String jobId;
    Long score;
    String explanation;
}

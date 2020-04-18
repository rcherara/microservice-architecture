package io.swag.corona.employer.domain;

import lombok.Value;

@Value
public class Job {

    String id;
    String title;
    String description;
    String location;
    Long qty;
    Long salary;
    boolean germanSkill;
    boolean englishSkill;
    boolean licenseSkill;
    boolean studentSkill;

}

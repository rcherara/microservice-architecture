package io.swag.corona.employee.domain;

import lombok.Value;

@Value
public class Employee {

    String id;
    String name;
    String ageGroup;
    String location;
    boolean germanSkill;
    boolean englishSkill;
    boolean licenseSkill;
    boolean studentSkill;

}

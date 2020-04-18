package io.swag.corona.contracting.domain;

import lombok.Value;

import java.time.LocalTime;

@Value
public class Contract {

    String id;
    String employeeId;
    String jobId;
    LocalTime timestamp;
    boolean videoVerified;
    boolean signed;

}

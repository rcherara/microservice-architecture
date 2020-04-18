package io.swag.corona.employer.domain;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class Employer {

    String id;
    String name;
    String domain;
    String homepage;

}

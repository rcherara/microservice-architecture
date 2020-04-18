package io.swag.corona.employer.adapter.out.postgres;

import io.swag.corona.employer.domain.Employer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employer")
@AllArgsConstructor
@NoArgsConstructor
public class EmployerJPA {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    String id;
    String name;
    String domain;
    String homepage;
    String accountId;

    static EmployerJPA of(Employer e, String accountId) {
        return new EmployerJPA(e.getId(), e.getName(), e.getDomain(), e.getHomepage(), accountId);
    }

    Employer toDomain() {
        return new Employer(this.id, this.name, this.domain, this.homepage);
    }

}

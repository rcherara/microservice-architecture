package io.swag.corona.employer.adapter.out.postgres;

import io.swag.corona.employer.domain.Job;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "job")
@AllArgsConstructor
@NoArgsConstructor
public class JobJPA {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
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

    static JobJPA of(Job j) {
        return new JobJPA(
                j.getId(),
                j.getTitle(),
                j.getDescription(),
                j.getLocation(),
                j.getQty(),
                j.getSalary(),
                j.isGermanSkill(),
                j.isEnglishSkill(),
                j.isLicenseSkill(),
                j.isStudentSkill()
        );
    }

    Job toDomain() {
        return new Job(this.id, this.title, this.description, this.location, this.qty, this.salary, this.germanSkill, this.englishSkill, this.licenseSkill, this.studentSkill);
    }
}

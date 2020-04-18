package io.swag.corona.contracting.adapter.out.postgres;

import io.swag.corona.contracting.domain.Contract;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalTime;

@Entity
@Table(name = "contract")
@NoArgsConstructor
@AllArgsConstructor
public class ContractJPA {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    String id;
    String employeeId;
    String jobId;
    LocalTime timestamp;
    boolean videoVerified;
    boolean signed;

    static ContractJPA of(Contract c) {
        return new ContractJPA(c.getId(), c.getEmployeeId(), c.getJobId(), c.getTimestamp(), c.isVideoVerified(), c.isSigned());
    }

    Contract toDomain() {
        return new Contract(this.id, this.employeeId, this.jobId, this.timestamp, this.videoVerified, this.signed);
    }

}

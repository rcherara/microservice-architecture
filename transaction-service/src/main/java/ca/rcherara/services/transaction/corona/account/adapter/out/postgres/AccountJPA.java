package io.swag.corona.account.adapter.out.postgres;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swag.corona.account.domain.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "accounts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AccountJPA implements Serializable {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    String id;

    @Column(name = "email", unique = true, nullable = false)
    String email;

    @JsonIgnore
    String password;

    String role;

    static AccountJPA of(Account a) {
        return new AccountJPA(null,
                a.getEmail(),
                a.getPassword(),
                a.getRole());
    }

    Account toDomain() {
        return new Account(this.id,
                this.email,
                this.password,
                this.role);
    }
}

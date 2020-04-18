package io.swag.corona.account.adapter.out.postgres;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface AccountJPARepository extends JpaRepository<AccountJPA, String> {
    Optional<AccountJPA> findByEmail(String email);
}

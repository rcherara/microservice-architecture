package io.swag.corona.account.adapter.out.postgres;

import io.swag.corona.account.application.port.out.FindAccountByEmailPort;
import io.swag.corona.account.application.port.out.SaveAccountPort;
import io.swag.corona.account.domain.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AccountPostgresAdapter implements FindAccountByEmailPort, SaveAccountPort {

    private final AccountJPARepository repository;

    @Override
    public Account accountByEmail(String email) {
        Optional<AccountJPA> accountJPA = repository.findByEmail(email);
        if (accountJPA.isEmpty()) {
            return null;
        }
        return accountJPA.get().toDomain();
    }

    @Override
    public Account save(Account account) {
        return repository.save(AccountJPA.of(account)).toDomain();
    }
}

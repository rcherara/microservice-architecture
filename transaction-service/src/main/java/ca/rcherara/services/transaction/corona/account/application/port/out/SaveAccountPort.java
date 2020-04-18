package io.swag.corona.account.application.port.out;

import io.swag.corona.account.domain.Account;

public interface SaveAccountPort {
    Account save(Account account);
}

package io.swag.corona.account.application.port.out;

import io.swag.corona.account.domain.Account;

public interface FindAccountByEmailPort {
    Account accountByEmail(String email);
}

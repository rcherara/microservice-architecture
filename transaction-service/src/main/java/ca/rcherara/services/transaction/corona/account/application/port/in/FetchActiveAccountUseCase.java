package io.swag.corona.account.application.port.in;

import io.swag.corona.account.domain.Account;

public interface FetchActiveAccountUseCase {

    Account activeAccount();
}

package io.swag.corona.account.application.port.in;

import io.swag.corona.account.domain.Account;

public interface ChangePasswordUseCase {

    Account changePassword(String oldPassword, String newPassword);
}

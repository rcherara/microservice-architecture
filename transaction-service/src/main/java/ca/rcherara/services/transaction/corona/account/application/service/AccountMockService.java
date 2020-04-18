package io.swag.corona.account.application.service;

import com.github.javafaker.Faker;
import io.swag.corona.account.application.port.in.ChangePasswordUseCase;
import io.swag.corona.account.application.port.in.CheckActiveSessionUseCase;
import io.swag.corona.account.application.port.in.FetchActiveAccountUseCase;
import io.swag.corona.account.application.port.in.RegisterUseCase;
import io.swag.corona.account.domain.Account;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class AccountMockService implements
        ChangePasswordUseCase, CheckActiveSessionUseCase, FetchActiveAccountUseCase, RegisterUseCase {

    private Faker faker;

    @PostConstruct
    void init() {
        this.faker = new Faker();
    }

    @Override
    public Account changePassword(String oldPassword, String newPassword) {

        return new Account(
                faker.bothify("????-????-????-????"),
                faker.bothify("????##@gmail.com"),
                newPassword,
                "ROLE_USER"
        );
    }

    @Override
    public boolean hasActiveSession() {
        return faker.bool().bool();
    }

    @Override
    public Account activeAccount() {

        return new Account(
               "-42",
                faker.bothify("????##@gmail.com"),
                faker.bothify("????-????-????-????"),
                "ROLE_USER"
        );
    }

    @Override
    public boolean register(String email, String password) {
        return faker.bool().bool();
    }
}

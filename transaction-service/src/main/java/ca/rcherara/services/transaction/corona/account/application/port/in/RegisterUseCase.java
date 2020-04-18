package io.swag.corona.account.application.port.in;

public interface RegisterUseCase {

    boolean register(String email, String password);
}

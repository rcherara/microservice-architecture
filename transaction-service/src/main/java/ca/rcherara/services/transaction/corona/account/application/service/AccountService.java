package io.swag.corona.account.application.service;

import io.swag.corona.account.application.port.in.CheckActiveSessionUseCase;
import io.swag.corona.account.application.port.in.FetchActiveAccountUseCase;
import io.swag.corona.account.application.port.in.RegisterUseCase;
import io.swag.corona.account.application.port.out.FindAccountByEmailPort;
import io.swag.corona.account.application.port.out.SaveAccountPort;
import io.swag.corona.account.domain.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

@Primary
@Component
@RequiredArgsConstructor
public class AccountService implements CheckActiveSessionUseCase, FetchActiveAccountUseCase, RegisterUseCase {

    private final FindAccountByEmailPort findAccountByEmailPort;
    private final SaveAccountPort saveAccountPort;
    private final PasswordEncoder passwordEncoder;

    public Account getAccountFromSecurityContext() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email;
        if (principal instanceof UserDetails) {
            email = ((UserDetails) principal).getUsername();
        } else {
            email = principal.toString();
        }
        Account account = findAccountByEmailPort.accountByEmail(email);
        if (account == null) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        return account;
    }

    @Override
    public boolean hasActiveSession() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        if (authentication != null) {
            return authentication.getAuthorities().stream()
                    .noneMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ANONYMOUS"));
        }
        return false;
    }

    @Override
    public Account activeAccount() {
        return getAccountFromSecurityContext();
    }

    @Override
    public boolean register(String email, String password) {
        Account account = new Account();
        account.setEmail(email);
        account.setPassword(passwordEncoder.encode(password));
        account.setRole("ROLE_USER");
        account = saveAccountPort.save(account);
        return account.getId() != null;
    }
}

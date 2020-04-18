package io.swag.corona.account.adapter.in;

import io.swag.corona.account.application.port.in.*;
import io.swag.corona.account.domain.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AccountController {

    private final RegisterUseCase registerUseCase;
    private final CheckActiveSessionUseCase checkActiveSessionUseCase;
    private final FetchActiveAccountUseCase activeAccountUseCase;
    private final ChangePasswordUseCase changePasswordUseCase;

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public boolean register(
            @RequestParam("email") String email,
            @RequestParam("password") String password
    ){
        return registerUseCase.register(email, password);
    }

    @RequestMapping(path = "/session", method = RequestMethod.GET)
    public boolean session(){
        return checkActiveSessionUseCase.hasActiveSession();
    }

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public Account activeAccount(){
        return activeAccountUseCase.activeAccount();
    }

    @RequestMapping(path = "/user", method = RequestMethod.PUT)
    public Account changePassword(
            @RequestParam("oldPassword") String oldPassword,
            @RequestParam("newPassword") String newPassword
    ) {
        return changePasswordUseCase.changePassword(oldPassword, newPassword);
    }
}

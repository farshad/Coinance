package ir.coinance.controller;

import io.swagger.annotations.ApiParam;
import ir.coinance.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signin")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/")
    public String login(
                        @ApiParam("Username") @RequestParam String username,
                        @ApiParam("Password") @RequestParam String password) {
        return authService.signin(username, password);
    }
}

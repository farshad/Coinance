package ir.coinance.controller;

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
    public String login(@RequestParam String username, @RequestParam String password) {
        return authService.signin(username, password);
    }
}

package ir.coinance.controller;

import io.swagger.annotations.ApiParam;
import ir.coinance.dto.UserDto;
import ir.coinance.service.AuthService;
import ir.coinance.service.SmsService;
import ir.coinance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private AuthService authService;

    @Autowired
    private SmsService smsService;

    @PostMapping
    public ResponseEntity add(@RequestBody @Valid UserDto dto){
        return new ResponseEntity<>(service.add(dto), HttpStatus.OK);
    }

    @PostMapping("/signin")
    public String login(//
                        @ApiParam("Username") @RequestParam String username,
                        @ApiParam("Password") @RequestParam String password) {
        smsService.send();
        return null;
        //return authService.signin(username, password);
    }

    @PostMapping("/signup")
    public String signup(@RequestBody UserDto userDto) {
        return authService.signup(userDto);
    }
}

package ir.coinance.controller;

import io.swagger.annotations.ApiParam;
import ir.coinance.dto.UserUpdateDto;
import ir.coinance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private UserService userService;

    @PostMapping("/changePassword")
    public ResponseEntity changePassword(@ApiParam("Password") @RequestParam String password) {
        return ResponseEntity.ok(userService.changePassword(password));
    }

    @PostMapping("/update")
    public ResponseEntity update(@ModelAttribute @Valid UserUpdateDto dto) {
        return ResponseEntity.ok(userService.updateProfile(dto));
    }
}

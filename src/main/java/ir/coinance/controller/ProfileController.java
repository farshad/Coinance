package ir.coinance.controller;

import ir.coinance.config.security.SecurityUtils;
import ir.coinance.dto.UserUpdateDto;
import ir.coinance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity current() {
        return ResponseEntity.ok(userService.current());
    }

    @PostMapping("/changePassword")
    public ResponseEntity changePassword(@RequestBody HashMap<String, String> req) {
        return ResponseEntity.ok(userService.changePassword(req.get("oldPassword"), req.get("newPassword")));
    }

    @PostMapping("/update")
    public ResponseEntity update(@ModelAttribute @Valid UserUpdateDto dto) {
        return ResponseEntity.ok(userService.updateProfile(dto));
    }
}

package ir.coinance.controller;

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

    @PostMapping("/changePassword")
    public ResponseEntity changePassword(@RequestBody HashMap<String, String> req) {
        return ResponseEntity.ok(userService.changePassword(req.get("oldPassword"), req.get("newPassword")));
    }

    @PostMapping("/update")
    public ResponseEntity update(@ModelAttribute @Valid UserUpdateDto dto) {
        return ResponseEntity.ok(userService.updateProfile(dto));
    }
}

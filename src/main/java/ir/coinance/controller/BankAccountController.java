package ir.coinance.controller;

import ir.coinance.dto.BankAccountDto;
import ir.coinance.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/bankAccount")
public class BankAccountController {

    @Autowired
    private BankAccountService service;

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody @Valid BankAccountDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping("/find")
    public ResponseEntity findByUserId() {
        return ResponseEntity.ok(service.findByUserId());
    }
}

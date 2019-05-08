package ir.coinance.controller;

import ir.coinance.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank")
public class BankController {

    @Autowired
    private BankService service;

    @GetMapping("/all")
    public ResponseEntity fetchAll() {
        return ResponseEntity.ok(service.fetchAll());
    }
}

package ir.coinance.controller;

import ir.coinance.service.SettlementRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/settlementRequest")
public class SettlementRequestController {

    @Autowired
    private SettlementRequestService service;

    @PostMapping("/add")
    public ResponseEntity add(@RequestParam("amount") Float amount){
        return ResponseEntity.ok(service.add(amount));
    }

    @PostMapping("/updateStatus")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity updateStatus(@RequestParam("id") Long id, @RequestParam("statusId") Long statusId){
        return ResponseEntity.ok(service.updateStatus(id, statusId));
    }

    @PostMapping("/findAll")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity findAll(Pageable pageable){
        return ResponseEntity.ok(service.findAll(pageable));
    }
}

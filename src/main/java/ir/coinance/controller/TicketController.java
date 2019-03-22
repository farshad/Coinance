package ir.coinance.controller;

import ir.coinance.dto.TicketAddDto;
import ir.coinance.dto.TicketDto;
import ir.coinance.dto.TicketFlatDto;
import ir.coinance.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService service;

    @PostMapping("/add")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<TicketFlatDto> add(@RequestBody @Valid TicketAddDto dto){
        return ResponseEntity.ok(service.add(dto));
    }

    @PostMapping("/updateStatus")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<TicketFlatDto> updateStatus(@RequestParam("id") Long id,
                                                  @RequestParam("statusId") Long statusId){
        return ResponseEntity.ok(service.updateStatus(id, statusId));
    }

    @GetMapping("/findAll")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Page<TicketDto>> findAll(Pageable pageable){
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping("/findByUser")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<Page<TicketFlatDto>> findByUser(Pageable pageable){
        return ResponseEntity.ok(service.findByUser(pageable));
    }
}

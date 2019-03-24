package ir.coinance.controller;

import ir.coinance.dto.TicketReplyDto;
import ir.coinance.service.TicketReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/ticketReply")
public class TicketReplyController {

    @Autowired
    private TicketReplyService service;

    @PostMapping("/add")
    public ResponseEntity<TicketReplyDto> add(@RequestBody @Valid TicketReplyDto dto){
        return ResponseEntity.ok(service.add(dto));
    }

    @PostMapping("/delete")
    public ResponseEntity<Boolean> delete(@RequestParam("id") Long id,
                                          @RequestParam("ticketId") Long ticketId){
        service.delete(id, ticketId);
        return ResponseEntity.ok(true);
    }
}

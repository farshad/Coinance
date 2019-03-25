package ir.coinance.controller;

import ir.coinance.dto.DealSuggestionDto;
import ir.coinance.service.DealSuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/dealSuggestion")
public class DealSuggestionController {

    @Autowired
    private DealSuggestionService service;

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid DealSuggestionDto dto){
        return ResponseEntity.ok(service.save(dto));
    }

    @PostMapping("/updateStatus")
    public ResponseEntity updateStatus(@RequestParam("id") Long id,
                                       @RequestParam("statusId") Long statusId){
        return ResponseEntity.ok(service.updateStatus(id, statusId));
    }

    @GetMapping("/findByUser")
    public ResponseEntity findByUser(Pageable pageable){
        return ResponseEntity.ok(service.findByUser(pageable));
    }

    @GetMapping("/findByType/{typeId}")
    public ResponseEntity findByType(@PathVariable Long typeId, Pageable pageable){
        return ResponseEntity.ok(service.findByType(typeId, pageable));
    }

}

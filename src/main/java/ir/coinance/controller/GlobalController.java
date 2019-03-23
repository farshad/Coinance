package ir.coinance.controller;

import ir.coinance.service.EnumTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/global")
public class GlobalController {

    @Autowired
    private EnumTypeService service;

    @GetMapping("/currentTime")
    public ResponseEntity getTime(){
        return ResponseEntity.ok(new Date());
    }

    @GetMapping("/fetchEnumTypes")
    public ResponseEntity fetchEnumTypes(){
        return ResponseEntity.ok(service.fetchEnumTypes());
    }
}

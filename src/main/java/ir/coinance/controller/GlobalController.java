package ir.coinance.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/global")
public class GlobalController {

    @GetMapping("/currentTime")
    public ResponseEntity getTime(){
        return ResponseEntity.ok(new Date());
    }
}

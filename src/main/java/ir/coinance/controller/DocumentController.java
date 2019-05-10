package ir.coinance.controller;

import ir.coinance.dto.DocumentUploadDto;
import ir.coinance.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/document")
public class DocumentController {

    @Autowired
    private DocumentService service;

    @PostMapping("/upload")
    public ResponseEntity upload(@ModelAttribute @Valid DocumentUploadDto dto) {
        return ResponseEntity.ok(service.save(dto.getDocumentAddDtos()));
    }

    @GetMapping("/")
    public ResponseEntity findByUserId(){
        return ResponseEntity.ok(service.findByUserId());
    }
}

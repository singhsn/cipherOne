package com.example.cipherone.controller;

import com.example.cipherone.entity.TokenizedDataEntity;
import com.example.cipherone.service.CipherOneService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Tag(name = "CipherOne API", description = "Endpoints for PII detection and tokenization")
@RestController
@RequestMapping("/api/cipher-one")
public class CipherOneController {

    private final CipherOneService cipherOneService;

    public CipherOneController(CipherOneService cipherOneService) {
        this.cipherOneService = cipherOneService;
    }

    @Operation(summary = "Process basic details")
    @PostMapping("/process-basic")
    public String processBasicDetails(@RequestParam String name,
                                      @RequestParam String phone,
                                      @RequestParam String email,
                                      @RequestParam String address) {
        return cipherOneService.processInput(name, phone, email, address);
    }

    @Operation(summary = "Process text input")
    @PostMapping("/process-text")
    public String processTextInput(@RequestBody String text) {
        return cipherOneService.processInput(text);
    }

    @Operation(summary = "Process CSV file")
    @PostMapping("/process-csv")
    public String processCsvFile(@RequestParam("file") MultipartFile file) {
        // Implement CSV parsing and processing logic here
        return "CSV processing not implemented yet.";
    }

    @Operation(summary = "Get all tokenized data records")
    @GetMapping("/all")
    public List<TokenizedDataEntity> getAllTokenizedData() {
        return cipherOneService.findAllTokenizedData();
    }
}
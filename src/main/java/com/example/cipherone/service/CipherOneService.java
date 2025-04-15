package com.example.cipherone.service;

import com.example.cipherone.entity.TokenizedDataEntity;
import com.example.cipherone.mapper.MLResponseParser;
import com.example.cipherone.mapper.PIIDataMapper;
import com.example.cipherone.model.MLResponse;
import com.example.cipherone.model.PIIResponse;
import com.example.cipherone.model.TokenRequest;
import com.example.cipherone.repository.TokenizedDataRepository;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CipherOneService {

    private static final String TOKENIZER_SERVICE_URL = "http://34.118.234.25/api/tokenizer/generate";
    private final TokenizedDataRepository repository;
    private final MLIntegrationService mlService;

    public CipherOneService(TokenizedDataRepository repository, MLIntegrationService mlService) {
        this.repository = repository;
        this.mlService = mlService;
    }

    /**
     * Processes input data by detecting PII, tokenizing it, and saving it to the database.
     *
     * @param name    The name input.
     * @param phone   The phone number input.
     * @param email   The email input.
     * @param address The address input.
     * @return A success message.
     */
    public String processInput(String name, String phone, String email, String address) {
        // Step 1: Detect PII using ML model
        Map<String, String> piiData = new HashMap<>();
        piiData.put("name", name);
        piiData.put("phone", phone);
        piiData.put("email", email);
        piiData.put("address", address);

        // Step 2: Tokenize PII data using Tokenizer Service
        Map<String, Map<String, String>> tokenizedData = tokenizePiiData(piiData);
        Map<String, String> tokenMap = tokenizedData.get("tokenMap");

        // Step 3: Save tokenized data to DB
        TokenizedDataEntity entity = PIIDataMapper.mapTokenizedData(tokenMap);

        repository.save(entity);

        return "Data processed and saved successfully!";
    }

    /**
     * Calls the Tokenizer Service to tokenize PII data.
     *
     * @param piiData The PII data detected by the ML service.
     * @return A map of tokenized PII data.
     */
    private Map<String, Map<String, String>> tokenizePiiData(Map<String, String> piiData) {
        RestTemplate restTemplate = new RestTemplate();

        TokenRequest tokenRequest = new TokenRequest();
        tokenRequest.setPiiMap(piiData);
        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        // Create HTTP entity
        HttpEntity<TokenRequest> requestEntity = new HttpEntity<>(tokenRequest, headers);

        try {
            // Call the Tokenizer Service
            ResponseEntity<Map> response = restTemplate.exchange(
                    TOKENIZER_SERVICE_URL,
                    HttpMethod.POST,
                    requestEntity,
                    Map.class
            );

            // Extract and cast the response body to Map<String, String>
            @SuppressWarnings("unchecked")
            Map<String, Map<String, String>> tokenizedData = (Map<String, Map<String, String>>) response.getBody();

            return tokenizedData;
        } catch (Exception e) {
            // Handle exceptions (e.g., connection errors)
            throw new RuntimeException("Failed to call Tokenizer Service: " + e.getMessage(), e);
        }
    }

    public String processInput(String text) {
        String piiDataString = mlService.detectPII(text);

        MLResponse piiData1 = MLResponseParser.parseResponse(piiDataString);

        Map<String, String> piiMap = PIIDataMapper.extractPiiData(piiData1);

        // Step 2: Tokenize PII data using Tokenizer Service
        if (piiMap != null && !piiMap.isEmpty()) {
            Map<String, Map<String, String>> tokenizedData = tokenizePiiData(piiMap);
            Map<String, String> tokenMap = tokenizedData.get("tokenMap");

            // Step 3: Save tokenized data to DB
            TokenizedDataEntity entity = PIIDataMapper.mapTokenizedData(tokenMap);

            // Save the entity
            repository.save(entity);
        }

        return "Data processed and saved successfully!";
    }

    public List<TokenizedDataEntity> findAllTokenizedData() {
        return repository.findAll();
    }
}
package com.example.cipherone.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class MLIntegrationService {

    private static final String PYTHON_PII_ENDPOINT = "http://<PYTHON-SERVER-URL>/detect-pii";

    /**
     * Invokes the Python endpoint to detect PII data.
     *
     * @param input The input text to process.
     * @return A Map containing PII data with string keys and string values.
     */
    public Map<String, String> detectPII(String input) {
        // Create RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        // Create request body
        Map<String, String> requestBody = Map.of("text", input);

        // Create HTTP entity
        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);

        try {
            // Invoke the Python endpoint
            ResponseEntity<Map> response = restTemplate.exchange(
                    PYTHON_PII_ENDPOINT,
                    HttpMethod.POST,
                    requestEntity,
                    Map.class
            );

            // Extract and cast the response body to Map<String, String>
            @SuppressWarnings("unchecked")
            Map<String, String> piiData = (Map<String, String>) response.getBody();

            return piiData;
        } catch (Exception e) {
            // Handle exceptions (e.g., connection errors)
            throw new RuntimeException("Failed to call Python PII detection service: " + e.getMessage(), e);
        }
    }
}
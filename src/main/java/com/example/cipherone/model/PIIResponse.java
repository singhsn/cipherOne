package com.example.cipherone.model;

import java.util.List;
import java.util.Map;

public class PIIResponse {

    private String raw_output;
    private Map<String, List<String>> structured_pii;

    // Getters and setters
    public String getRaw_output() {
        return raw_output;
    }

    public void setRaw_output(String raw_output) {
        this.raw_output = raw_output;
    }

    public Map<String, List<String>> getStructured_pii() {
        return structured_pii;
    }

    public void setStructured_pii(Map<String, List<String>> structured_pii) {
        this.structured_pii = structured_pii;
    }
}

package com.example.cipherone.mapper;

import com.example.cipherone.model.MLResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
 * @author sachchidanand singh
 */
public class MLResponseParser {

    public static MLResponse parseResponse(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        MLResponse mlResponse = new MLResponse();

        try {
            JsonNode rootNode = mapper.readTree(jsonString);

            // Set raw_output
            mlResponse.setRaw_output(rootNode.path("raw_output").asText());

            // Get structured_pii node
            JsonNode piiNode = rootNode.path("structured_pii");

            if (piiNode != null && piiNode.isObject()) {
                mlResponse.setCompany(mapper.convertValue(piiNode.path("company"), List.class));
                mlResponse.setCredit_card_number(mapper.convertValue(piiNode.path("credit_card_number"), List.class));
                mlResponse.setCredit_card_security_code(mapper.convertValue(piiNode.path("credit_card_security_code"), List.class));
                mlResponse.setCustomer_id(mapper.convertValue(piiNode.path("customer_id"), List.class));
                mlResponse.setDate_of_birth(mapper.convertValue(piiNode.path("date_of_birth"), List.class));
                mlResponse.setDriver_license_number(mapper.convertValue(piiNode.path("driver_license_number"), List.class));
                mlResponse.setEmail(mapper.convertValue(piiNode.path("email"), List.class));
                mlResponse.setEmployee_id(mapper.convertValue(piiNode.path("employee_id"), List.class));
                mlResponse.setFirst_name(mapper.convertValue(piiNode.path("first_name"), List.class));
                mlResponse.setLast_name(mapper.convertValue(piiNode.path("last_name"), List.class));
                mlResponse.setName(mapper.convertValue(piiNode.path("name"), List.class));
                mlResponse.setPassport_number(mapper.convertValue(piiNode.path("passport_number"), List.class));
                mlResponse.setPassword(mapper.convertValue(piiNode.path("password"), List.class));
                mlResponse.setPhone_number(mapper.convertValue(piiNode.path("phone_number"), List.class));
                mlResponse.setSocial_security_number(mapper.convertValue(piiNode.path("social_security_number"), List.class));
                mlResponse.setStreet_address(mapper.convertValue(piiNode.path("street_address"), List.class));
                mlResponse.setUser_name(mapper.convertValue(piiNode.path("user_name"), List.class));
            }

        } catch (Exception e) {
            e.printStackTrace(); // Use proper logging in real projects
        }

        return mlResponse;
    }
}

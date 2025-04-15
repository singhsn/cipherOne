package com.example.cipherone.mapper;

import com.example.cipherone.entity.TokenizedDataEntity;
import com.example.cipherone.model.MLResponse;

import java.util.*;

/**
 * @author sachchidanand singh
 */

public class PIIDataMapper {

    public static Map<String, String> extractPiiData(MLResponse mlResponse) {
        Map<String, String> piiData = new HashMap<>();

        if (mlResponse.getEmail() != null && !mlResponse.getEmail().isEmpty()) {
            piiData.put("email", mlResponse.getEmail().get(0));
        }
        if (mlResponse.getSocial_security_number() != null && !mlResponse.getSocial_security_number().isEmpty()) {
            piiData.put("social_security_number", mlResponse.getSocial_security_number().get(0));
        }
        if (mlResponse.getDate_of_birth() != null && !mlResponse.getDate_of_birth().isEmpty()) {
            piiData.put("date_of_birth", mlResponse.getDate_of_birth().get(0));
        }
        if (mlResponse.getPhone_number() != null && !mlResponse.getPhone_number().isEmpty()) {
            piiData.put("phone_number", mlResponse.getPhone_number().get(0));
        }
        if (mlResponse.getCredit_card_number() != null && !mlResponse.getCredit_card_number().isEmpty()) {
            piiData.put("credit_card_number", mlResponse.getCredit_card_number().get(0));
        }
        if (mlResponse.getCredit_card_security_code() != null && !mlResponse.getCredit_card_security_code().isEmpty()) {
            piiData.put("credit_card_security_code", mlResponse.getCredit_card_security_code().get(0));
        }
        if (mlResponse.getDriver_license_number() != null && !mlResponse.getDriver_license_number().isEmpty()) {
            piiData.put("driver_license_number", mlResponse.getDriver_license_number().get(0));
        }
        if (mlResponse.getFirst_name() != null && !mlResponse.getFirst_name().isEmpty()) {
            piiData.put("first_name", mlResponse.getFirst_name().get(0));
        }
        if (mlResponse.getLast_name() != null && !mlResponse.getLast_name().isEmpty()) {
            piiData.put("last_name", mlResponse.getLast_name().get(0));
        }
        if (mlResponse.getName() != null && !mlResponse.getName().isEmpty()) {
            piiData.put("name", mlResponse.getName().get(0));
        }
        if (mlResponse.getPassport_number() != null && !mlResponse.getPassport_number().isEmpty()) {
            piiData.put("passport_number", mlResponse.getPassport_number().get(0));
        }
        if (mlResponse.getPassword() != null && !mlResponse.getPassword().isEmpty()) {
            piiData.put("password", mlResponse.getPassword().get(0));
        }
        if (mlResponse.getStreet_address() != null && !mlResponse.getStreet_address().isEmpty()) {
            piiData.put("street_address", mlResponse.getStreet_address().get(0));
        }
        if (mlResponse.getUser_name() != null && !mlResponse.getUser_name().isEmpty()) {
            piiData.put("user_name", mlResponse.getUser_name().get(0));
        }
        if (mlResponse.getCompany() != null && !mlResponse.getCompany().isEmpty()) {
            piiData.put("company", mlResponse.getCompany().get(0));
        }
        if (mlResponse.getEmployee_id() != null && !mlResponse.getEmployee_id().isEmpty()) {
            piiData.put("employee_id", mlResponse.getEmployee_id().get(0));
        }
        if (mlResponse.getCustomer_id() != null && !mlResponse.getCustomer_id().isEmpty()) {
            piiData.put("customer_id", mlResponse.getCustomer_id().get(0));
        }

        return piiData;
    }

    public static TokenizedDataEntity mapTokenizedData(Map<String, String> tokenMap) {

        TokenizedDataEntity entity = new TokenizedDataEntity();
        entity.setName(tokenMap.getOrDefault("name", null));
        entity.setPhoneNumber(tokenMap.getOrDefault("phone_number", null));
        entity.setEmail(tokenMap.getOrDefault("email", null));
        entity.setAddress(tokenMap.getOrDefault("street_address", null));
        entity.setOriginalText(null); // assuming you have this variable
        entity.setStatus("PROCESSED");

// Tokenized PII Fields
        entity.setCompany(tokenMap.getOrDefault("company", null));
        entity.setCreditCardNumber(tokenMap.getOrDefault("credit_card_number", null));
        entity.setCreditCardSecurityCode(tokenMap.getOrDefault("credit_card_security_code", null));
        entity.setCustomerId(tokenMap.getOrDefault("customer_id", null));
        entity.setDateOfBirth(tokenMap.getOrDefault("date_of_birth", null));
        entity.setDriverLicenseNumber(tokenMap.getOrDefault("driver_license_number", null));
        entity.setEmployeeId(tokenMap.getOrDefault("employee_id", null));
        entity.setFirstName(tokenMap.getOrDefault("first_name", null));
        entity.setLastName(tokenMap.getOrDefault("last_name", null));
        entity.setPassportNumber(tokenMap.getOrDefault("passport_number", null));
        entity.setPassword(tokenMap.getOrDefault("password", null));
        entity.setSocialSecurityNumber(tokenMap.getOrDefault("social_security_number", null));
        entity.setStreetAddress(tokenMap.getOrDefault("street_address", null));
        entity.setUserName(tokenMap.getOrDefault("user_name", null));

        return entity;
    }
}

package com.example.cipherone.model;

import java.util.List;

public class MLResponse {

    private String raw_output;

    private List<String> company;
    private List<String> credit_card_number;
    private List<String> credit_card_security_code;
    private List<String> customer_id;
    private List<String> date_of_birth;
    private List<String> driver_license_number;
    private List<String> email;
    private List<String> employee_id;
    private List<String> first_name;
    private List<String> last_name;
    private List<String> name;
    private List<String> passport_number;
    private List<String> password;
    private List<String> phone_number;
    private List<String> social_security_number;
    private List<String> street_address;
    private List<String> user_name;

    // Getters and Setters

    public String getRaw_output() {
        return raw_output;
    }

    public void setRaw_output(String raw_output) {
        this.raw_output = raw_output;
    }

    public List<String> getCompany() {
        return company;
    }

    public void setCompany(List<String> company) {
        this.company = company;
    }

    public List<String> getCredit_card_number() {
        return credit_card_number;
    }

    public void setCredit_card_number(List<String> credit_card_number) {
        this.credit_card_number = credit_card_number;
    }

    public List<String> getCredit_card_security_code() {
        return credit_card_security_code;
    }

    public void setCredit_card_security_code(List<String> credit_card_security_code) {
        this.credit_card_security_code = credit_card_security_code;
    }

    public List<String> getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(List<String> customer_id) {
        this.customer_id = customer_id;
    }

    public List<String> getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(List<String> date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public List<String> getDriver_license_number() {
        return driver_license_number;
    }

    public void setDriver_license_number(List<String> driver_license_number) {
        this.driver_license_number = driver_license_number;
    }

    public List<String> getEmail() {
        return email;
    }

    public void setEmail(List<String> email) {
        this.email = email;
    }

    public List<String> getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(List<String> employee_id) {
        this.employee_id = employee_id;
    }

    public List<String> getFirst_name() {
        return first_name;
    }

    public void setFirst_name(List<String> first_name) {
        this.first_name = first_name;
    }

    public List<String> getLast_name() {
        return last_name;
    }

    public void setLast_name(List<String> last_name) {
        this.last_name = last_name;
    }

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    public List<String> getPassport_number() {
        return passport_number;
    }

    public void setPassport_number(List<String> passport_number) {
        this.passport_number = passport_number;
    }

    public List<String> getPassword() {
        return password;
    }

    public void setPassword(List<String> password) {
        this.password = password;
    }

    public List<String> getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(List<String> phone_number) {
        this.phone_number = phone_number;
    }

    public List<String> getSocial_security_number() {
        return social_security_number;
    }

    public void setSocial_security_number(List<String> social_security_number) {
        this.social_security_number = social_security_number;
    }

    public List<String> getStreet_address() {
        return street_address;
    }

    public void setStreet_address(List<String> street_address) {
        this.street_address = street_address;
    }

    public List<String> getUser_name() {
        return user_name;
    }

    public void setUser_name(List<String> user_name) {
        this.user_name = user_name;
    }
}

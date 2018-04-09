package com.phani.services.rest.restfulservices.clientDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerDTO {

    private String firstname;

    private String lastname;

    @JsonProperty("customer_url")
    private String customerUrl;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCustomerUrl() {
        return customerUrl;
    }

    public void setCustomerUrl(String customerUrl) {
        this.customerUrl = customerUrl;
    }
}

package com.phani.services.rest.restfulservices.clientDTO;

import java.util.List;

public class CustomerListDTO {

    List<CustomerDTO> customers;

    public CustomerListDTO() {
    }

    public CustomerListDTO(List<CustomerDTO> customers) {
        this.customers = customers;
    }

    public List<CustomerDTO> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerDTO> customers) {
        this.customers = customers;
    }
}

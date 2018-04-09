package com.phani.services.rest.restfulservices.clientDTO;

import java.util.List;

public class VendorListDTO {

    List<VendorDTO> vendors;

    public List<VendorDTO> getVendors() {
        return vendors;
    }

    public void setVendors(List<VendorDTO> vendors) {
        this.vendors = vendors;
    }
}

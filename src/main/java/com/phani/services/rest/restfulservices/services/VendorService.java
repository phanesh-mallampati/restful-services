package com.phani.services.rest.restfulservices.services;

import com.phani.services.rest.restfulservices.clientDTO.VendorDTO;
import com.phani.services.rest.restfulservices.clientDTO.VendorListDTO;

public interface VendorService {

    VendorDTO getVendorById(Long id);

    VendorListDTO getAllVendors();

    VendorDTO createNewVendor(VendorDTO vendorDTO);

    VendorDTO saveVendorByDTO(Long id, VendorDTO vendorDTO);

   // VendorDTO patchVendor(Long id, VendorDTO vendorDTO);

    void deleteVendorById(Long id);
}

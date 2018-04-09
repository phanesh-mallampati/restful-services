package com.phani.services.rest.restfulservices.mapper;

import com.phani.services.rest.restfulservices.clientDTO.VendorDTO;
import com.phani.services.rest.restfulservices.domain.Vendor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VendorMapper {

    VendorMapper INSTANCE = Mappers.getMapper(VendorMapper.class);

    VendorDTO vendorToVendorDTO(Vendor vendor);

    Vendor vendorDTOtoVendor(VendorDTO vendorDTO);
}

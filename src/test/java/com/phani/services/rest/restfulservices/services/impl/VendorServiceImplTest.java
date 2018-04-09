package com.phani.services.rest.restfulservices.services.impl;

import com.phani.services.rest.restfulservices.clientDTO.VendorDTO;
import com.phani.services.rest.restfulservices.domain.Vendor;
import com.phani.services.rest.restfulservices.exceptions.ResourceNotFoundException;
import com.phani.services.rest.restfulservices.mapper.VendorMapper;
import com.phani.services.rest.restfulservices.repositories.VendorRepository;
import com.phani.services.rest.restfulservices.services.VendorService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

public class VendorServiceImplTest {

    public static final String NAME_1 = "My Vendor";
    public static final long ID_1 = 1L;
    public static final String NAME_2 = "My Vendor";
    public static final long ID_2 = 1L;

    @Mock
    VendorRepository vendorRepository;

    VendorService vendorService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        vendorService = new VendorServiceImpl(VendorMapper.INSTANCE, vendorRepository);
    }

    @Test
    public void getVendorById() throws Exception {
        Vendor vendor = getVendor1();

        given(vendorRepository.findById(anyLong())).willReturn(Optional.of(vendor));

        VendorDTO vendorDTO = vendorService.getVendorById(1L);

        then(vendorRepository).should(times(1)).findById(anyLong());
        assertEquals(vendorDTO.getName(), NAME_1);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void getVendorByIdNotFound() throws Exception {
       //mockito BBD syntax since mockito 1.10.0
        given(vendorRepository.findById(anyLong())).willReturn(Optional.empty());
        //when
        VendorDTO vendorDTO = vendorService.getVendorById(1L);
        //then
        then(vendorRepository).should(times(1)).findById(anyLong());
    }


   @Test
    public void deleteVendorById() throws Exception {
        vendorService.deleteVendorById(1L);
        //then
        then(vendorRepository).should().deleteById(anyLong());
   }

   private Vendor getVendor1() {
        Vendor vendor = new Vendor();
        vendor.setName(NAME_1);
        vendor.setId(ID_1);
        return vendor;
    }

    private Vendor getVendor2() {
        Vendor vendor = new Vendor();
        vendor.setName(NAME_2);
        vendor.setId(ID_2);
        return vendor;
    }
}
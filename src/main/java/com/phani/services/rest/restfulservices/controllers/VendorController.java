package com.phani.services.rest.restfulservices.controllers;

import com.phani.services.rest.restfulservices.clientDTO.VendorDTO;
import com.phani.services.rest.restfulservices.clientDTO.VendorListDTO;
import com.phani.services.rest.restfulservices.services.VendorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.phani.services.rest.restfulservices.controllers.VendorController.BASE_URL;

@RestController
@RequestMapping(BASE_URL)
public class VendorController {

    public static final String BASE_URL = "/rest/vendor";

    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public VendorListDTO getVendorList(){
        return vendorService.getAllVendors();
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO getVendorById(@PathVariable Long id){
        return vendorService.getVendorById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VendorDTO createNewVendor(@RequestBody VendorDTO vendorDTO){
        return vendorService.createNewVendor(vendorDTO);
    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO updateVendor(@PathVariable Long id, @RequestBody VendorDTO vendorDTO){
        return vendorService.saveVendorByDTO(id, vendorDTO);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteVendor(@PathVariable Long id){
        vendorService.deleteVendorById(id);
    }
}

package com.phani.services.rest.restfulservices.repositories;

import com.phani.services.rest.restfulservices.domain.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
}

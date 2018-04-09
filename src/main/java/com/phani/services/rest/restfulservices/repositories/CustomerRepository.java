package com.phani.services.rest.restfulservices.repositories;

import com.phani.services.rest.restfulservices.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
}

package com.phani.services.rest.restfulservices.mapper;

import com.phani.services.rest.restfulservices.clientDTO.CustomerDTO;
import com.phani.services.rest.restfulservices.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDTO customerToCustomerDTO(Customer customer);

    Customer customerDtoToCustomer(CustomerDTO customerDTO);
}

package com.trjerome.msscbrewery.web.services;

import com.trjerome.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getByCustomerId(UUID id);
    CustomerDto updateCustomer(UUID id, CustomerDto customerDto);
    CustomerDto createCustomer(CustomerDto customerDto);
    CustomerDto deleteCustomerById(UUID customerId);
}

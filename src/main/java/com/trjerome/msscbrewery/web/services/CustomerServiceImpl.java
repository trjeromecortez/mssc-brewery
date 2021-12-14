package com.trjerome.msscbrewery.web.services;

import com.trjerome.msscbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getByCustomerId(UUID customerId) {
        return CustomerDto.builder().id(UUID.randomUUID())
                .customerName("Sample Customer")
                .build();
    }

    @Override
    public CustomerDto updateCustomer(UUID id, CustomerDto customerDto) {
        return null;
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        return CustomerDto.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public CustomerDto deleteCustomerById(UUID customerId) {
        return null;
    }
}

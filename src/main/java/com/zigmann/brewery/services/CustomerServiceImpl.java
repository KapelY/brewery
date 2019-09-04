package com.zigmann.brewery.services;

import com.zigmann.brewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID uuid) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("Lola")
                .build();
    }
}

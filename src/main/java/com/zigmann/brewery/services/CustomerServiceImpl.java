package com.zigmann.brewery.services;

import com.zigmann.brewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDto) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("Some customer")
                .build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        // todo update
    }

    @Override
    public void deleteCustomer(UUID customerId) {
        log.debug("Deleting customer" + customerId.toString());
    }

    @Override
    public CustomerDto getCustomerById(UUID uuid) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("Lola")
                .build();
    }
}

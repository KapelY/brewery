package com.zigmann.brewery.services;

import com.zigmann.brewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {

    CustomerDto getCustomerById(UUID uuid);
}

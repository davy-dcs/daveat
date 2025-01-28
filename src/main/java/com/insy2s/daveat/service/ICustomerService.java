package com.insy2s.daveat.service;

import com.insy2s.daveat.domain.Customer;
import com.insy2s.daveat.dto.CustomerRequest;
import com.insy2s.daveat.dto.CustomerResponse;

import java.util.List;
import java.util.UUID;

public interface ICustomerService {
    CustomerResponse create(CustomerRequest customerRequest);
    List<CustomerResponse> read();
    CustomerResponse readByUuid(UUID uuid);
    CustomerResponse update(UUID uuid, CustomerRequest customerRequest);
    void delete(UUID uuid);
}

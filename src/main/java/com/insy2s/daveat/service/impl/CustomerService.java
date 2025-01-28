package com.insy2s.daveat.service.impl;

import com.insy2s.daveat.domain.Customer;
import com.insy2s.daveat.dto.CustomerRequest;
import com.insy2s.daveat.dto.CustomerResponse;
import com.insy2s.daveat.dto.mapper.ICustomerMapper;
import com.insy2s.daveat.exception.CustomerNotFoundException;
import com.insy2s.daveat.repository.ICustomerRepository;
import com.insy2s.daveat.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CustomerService implements ICustomerService {
    private final ICustomerRepository customerRepository;
    private final ICustomerMapper customerMapper;

    @Override
    public CustomerResponse create(CustomerRequest customerRequest) {
        return customerMapper.customerToCustomerResponse(customerRepository
                .save(customerMapper.customerRequestToCustomer(customerRequest))
        );
    }

    @Override
    public List<CustomerResponse> read() {
        return customerMapper.customersToCustomerResponseList(
                customerRepository.findAll()
        );
    }

    @Override
    public CustomerResponse readByUuid(UUID uuid) {
        return customerMapper.customerToCustomerResponse(getByUuid(uuid));
    }

    @Override
    public CustomerResponse update(UUID uuid, CustomerRequest customerRequest) {
        Customer customer = getByUuid(uuid);
        if (customerRequest.name() != null) {
            customer.setName(customerRequest.name());
        }
        if (customerRequest.email() != null) {
            customer.setEmail(customerRequest.email());
        }
        if (customerRequest.phone() != null) {
            customer.setPhone(customerRequest.phone());
        }
        return customerMapper.customerToCustomerResponse(customerRepository.save(customer));
    }

    @Override
    public void delete(UUID uuid) {
        CustomerResponse customerResponse = readByUuid(uuid);
        customerRepository.delete(customerMapper.customerResponseToCustomer(customerResponse));
    }

    private Customer getByUuid(UUID uuid) {
        return customerRepository.findByUuid(uuid).orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
    }
}

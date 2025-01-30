package com.insy2s.daveat.service.impl;

import com.insy2s.daveat.dto.CustomerRequest;
import com.insy2s.daveat.dto.CustomerResponse;
import com.insy2s.daveat.exception.customer.CustomerNotFoundException;
import com.insy2s.daveat.repository.ICustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class CustomerServiceImplTest {

    @InjectMocks
    private CustomerServiceImpl customerService;
    @Mock
    private ICustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void readByUuid() {
        when(customerRepository.findByUuid(UUID.randomUUID())).thenThrow(CustomerNotFoundException.class);

        final CustomerResponse actual = customerService.readByUuid(UUID.randomUUID());

        assertEquals(new CustomerNotFoundException("Customer not found"), actual);
    }

}
package com.insy2s.daveat.controller;

import com.insy2s.daveat.dto.CustomerRequest;
import com.insy2s.daveat.dto.CustomerResponse;
import com.insy2s.daveat.exception.customer.CustomerAlreadyExistException;
import com.insy2s.daveat.exception.customer.CustomerNotFoundException;
import com.insy2s.daveat.service.ICustomerService;
import com.insy2s.daveat.service.impl.CustomerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class CustomerControllerTest {

    @InjectMocks
    private CustomerController customerController;
    @Mock
    private ICustomerService customerService;


    private CustomerRequest customerRequest;
    private CustomerResponse customerResponse;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        customerRequest = new CustomerRequest("John", "john@mail.test", "0123456789");
        customerResponse = new CustomerResponse(UUID.randomUUID(), "John", "john@mail.test", "0123456789");
    }

    @Test
    void whenCreateCustomer_thenReturnStatus201() {
        when(customerService.create(customerRequest)).thenReturn(customerResponse);

        final ResponseEntity<CustomerResponse> actual = customerController.postCustomer(customerRequest);

        assertEquals(201, actual.getStatusCode().value());
        assertNotNull(actual.getBody());
        assertEquals(customerResponse.uuid(), actual.getBody().uuid());
        assertEquals(customerResponse.name(), actual.getBody().name());
        assertEquals(customerResponse.email(), actual.getBody().email());
        assertEquals(customerResponse.phone(), actual.getBody().phone());
    }

    @Test
    void whenCreateCustomer_AlreadyExist_thenReturnStatus409()  {
        when(customerService.create(customerRequest)).thenThrow(CustomerAlreadyExistException.class);

        final ResponseEntity<CustomerResponse> actual = customerController.postCustomer(customerRequest);

        assertEquals(409, actual.getStatusCode().value());
    }

    @Test
    void whenGetCustomer_thenReturnStatus200() {
        when(customerService.readByUuid(customerResponse.uuid())).thenReturn(customerResponse);

        final ResponseEntity<CustomerResponse> actual = customerController.getCustomer(customerResponse.uuid());

        assertEquals(200, actual.getStatusCode().value());
    }

    @Test
    void whenGetCustomer_NotFound_thenReturnStatus404() {
        when(customerService.readByUuid(UUID.randomUUID())).thenThrow(CustomerNotFoundException.class);
        ResponseEntity<CustomerResponse> actual = customerController.getCustomer(UUID.randomUUID());
        assertEquals(404, actual.getStatusCode().value());
    }

    @Test
    void whenGetCustomers_thenReturnStatus200() {
        when(customerService.read()).thenReturn(new ArrayList<>());

        final ResponseEntity<List<CustomerResponse>> actual = customerController.getCustomers();

        assertEquals(200, actual.getStatusCode().value());
    }

    @Test
    void whenPutCustomer_thenReturnStatus200() {
        when(customerService.update(UUID.randomUUID(), customerRequest)).thenReturn(customerResponse);

        final ResponseEntity<CustomerResponse> actual = customerController.putCustomer(UUID.randomUUID(), customerRequest);

        assertEquals(200, actual.getStatusCode().value());
    }

    @Test
    void whenDeleteCustomer_thenReturnStatus200() {
        assertEquals(200, customerController.deleteCustomer(UUID.randomUUID()).getStatusCode().value());
    }

    @Test
    void getCustomer() {
    }

    @Test
    void putCustomer() {
    }

    @Test
    void deleteCustomer() {
    }
}
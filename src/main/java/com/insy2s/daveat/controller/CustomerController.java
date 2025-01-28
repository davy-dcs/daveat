package com.insy2s.daveat.controller;

import com.insy2s.daveat.domain.Customer;
import com.insy2s.daveat.dto.CustomerRequest;
import com.insy2s.daveat.dto.CustomerResponse;
import com.insy2s.daveat.service.ICustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {
    private final ICustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity<CustomerResponse> postCustomer(@RequestBody @Valid CustomerRequest customerRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.create(customerRequest));
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getCustomers() {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.read());
    }

    @GetMapping("/{customer}")
    public ResponseEntity<CustomerResponse> getCustomer(@PathVariable UUID customer) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.readByUuid(customer));
    }

    @PutMapping("/{customer}")
    public ResponseEntity<CustomerResponse> putCustomer(@PathVariable UUID customer, @RequestBody CustomerRequest customerRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.update(customer, customerRequest));
    }

    @DeleteMapping("/{customer}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable UUID customer) {
        customerService.delete(customer);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

package com.insy2s.daveat.dto.mapper;

import com.insy2s.daveat.domain.Customer;
import com.insy2s.daveat.dto.CustomerRequest;
import com.insy2s.daveat.dto.CustomerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ICustomerMapper {
    Customer customerResponseToCustomer(CustomerResponse customerResponse);
    CustomerResponse customerToCustomerResponse(Customer customer);
    List<CustomerResponse> customersToCustomerResponseList(List<Customer> customers);
    Customer customerRequestToCustomer(CustomerRequest customerRequest);
}

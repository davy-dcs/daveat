package com.insy2s.daveat.dto.mapper;

import com.insy2s.daveat.domain.Customer;
import com.insy2s.daveat.dto.CustomerRequest;
import com.insy2s.daveat.dto.CustomerResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-29T13:37:02+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class ICustomerMapperImpl implements ICustomerMapper {

    @Override
    public Customer customerResponseToCustomer(CustomerResponse customerResponse) {
        if ( customerResponse == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setName( customerResponse.name() );
        customer.setEmail( customerResponse.email() );
        customer.setPhone( customerResponse.phone() );

        return customer;
    }

    @Override
    public CustomerResponse customerToCustomerResponse(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        UUID uuid = null;
        String name = null;
        String email = null;
        String phone = null;

        uuid = customer.getUuid();
        name = customer.getName();
        email = customer.getEmail();
        phone = customer.getPhone();

        CustomerResponse customerResponse = new CustomerResponse( uuid, name, email, phone );

        return customerResponse;
    }

    @Override
    public List<CustomerResponse> customersToCustomerResponseList(List<Customer> customers) {
        if ( customers == null ) {
            return null;
        }

        List<CustomerResponse> list = new ArrayList<CustomerResponse>( customers.size() );
        for ( Customer customer : customers ) {
            list.add( customerToCustomerResponse( customer ) );
        }

        return list;
    }

    @Override
    public Customer customerRequestToCustomer(CustomerRequest customerRequest) {
        if ( customerRequest == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setName( customerRequest.name() );
        customer.setEmail( customerRequest.email() );
        customer.setPhone( customerRequest.phone() );

        return customer;
    }
}

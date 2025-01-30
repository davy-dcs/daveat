package com.insy2s.daveat.repository;

import com.insy2s.daveat.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByUuid(@NonNull UUID uuid);
    boolean existsByEmailOrPhone(String email, String phone);
}

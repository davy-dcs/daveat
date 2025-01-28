package com.insy2s.daveat.repository;

import com.insy2s.daveat.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order, Long> {
}

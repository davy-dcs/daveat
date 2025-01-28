package com.insy2s.daveat.repository;

import com.insy2s.daveat.domain.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDishRepository extends JpaRepository<Dish, Long> {
}

package com.insy2s.daveat.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long id;

    @FutureOrPresent(message = "The date must be present or future.")
    @NotNull(message = "Date cannot be null.")
    private LocalDate date;

    @Setter
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @NotNull(message = "Order must contain a customer.")
    private Customer customer;

    @PrePersist
    private void create() {
        this.date = LocalDate.now();
        this.status = Status.RECEIVED;
    }
}

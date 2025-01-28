package com.insy2s.daveat.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long id;

    private UUID uuid;

    @Setter
    @Column(nullable = false, length = 50)
    @Size(min = 1, max = 50)
    @NotNull(message = "Customer must have a name.")
    private String name;


    @Setter
    @Column(unique = true)
    @Email(message = "Invalid email address.")
    @NotNull(message = "Customer must have a email.")
    private String email;

    @Setter
    @Size(min = 10, max = 10)
    @Digits(integer = 10, fraction = 0)
    @Column(nullable = false, unique = true, length = 10)
    private String phone;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    @PrePersist
    private void create() {
        this.uuid = UUID.randomUUID();
        this.orders = new ArrayList<>();
    }

}

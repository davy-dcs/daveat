package com.insy2s.daveat.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long id;

    @Setter
    @Column(nullable = false, length = 50)
    @Size(min = 1, max = 50)
    @NotNull(message = "Dish must have a name.")
    private String name;

    @Setter
    @NotNull(message = "Dish must have a description.")
    @Size(message = "Description must not exceed 255 characters. ", max = 255)
    private String description;

    @Setter
    @Column(nullable = false)
    @Positive(message = "Price must be positive.")
    @NotNull(message = "Price must have a value.")
    private double price;

    @Setter
    @Column(nullable = false)
    private boolean available;

    @PrePersist
    private void create() {
        this.available = true;
    }
}

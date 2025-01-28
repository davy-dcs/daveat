package com.insy2s.daveat.dto;


import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public record CustomerRequest(
        @Size(min = 1, max = 50)
        @NotNull(message = "Customer must have a name.")
        String name,

        @Email(message = "Invalid email address.")
        @NotNull(message = "Customer must have a email.")
        String email,

        @Size(min = 10, max = 10)
        @Digits(integer = 10, fraction = 0)
        String phone

) implements Serializable {
}

package com.insy2s.daveat.dto;

import java.io.Serializable;
import java.util.UUID;

public record CustomerResponse(UUID uuid, String name,String email, String phone) implements Serializable {
}

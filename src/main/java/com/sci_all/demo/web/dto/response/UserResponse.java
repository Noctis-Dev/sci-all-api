package com.sci_all.demo.web.dto.response;

import java.time.LocalDate;
import java.util.UUID;

public record UserResponse(
    UUID userUuid,
    String role,
    String username,
    String email,
    String phoneNumber,
    LocalDate createdAt
) { }

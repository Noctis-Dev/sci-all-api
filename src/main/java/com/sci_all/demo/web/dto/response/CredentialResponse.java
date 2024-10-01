package com.sci_all.demo.web.dto.response;

import java.time.LocalDate;
import java.util.UUID;

public record CredentialResponse(
    UUID credentialUuid,
    String email,
    String phoneNumber,
    Boolean verified,
    LocalDate createdAt
) { }

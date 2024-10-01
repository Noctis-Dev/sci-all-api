package com.sci_all.demo.web.dto.request;

public record CredentialRequest(
    String email,
    String phoneNumber,
    String password
) { }

package com.sci_all.demo.web.dto.request;

public record UserRequest(
        String role,
        String username,
        String email,
        String phoneNumber,
        String password
) { }

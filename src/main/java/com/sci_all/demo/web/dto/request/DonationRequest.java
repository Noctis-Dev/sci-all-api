package com.sci_all.demo.web.dto.request;

public record DonationRequest(
        String email,
        Float amount
) { }

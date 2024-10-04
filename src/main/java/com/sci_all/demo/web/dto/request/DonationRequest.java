package com.sci_all.demo.web.dto.request;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

public record DonationRequest(
        Float amount,
        UUID streamId,
        UUID authorId
) { }

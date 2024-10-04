package com.sci_all.demo.web.dto.request;

import java.util.UUID;

public record PublicationRequest(
        UUID userId,
        String body
) { }

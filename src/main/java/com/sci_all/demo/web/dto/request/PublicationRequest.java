package com.sci_all.demo.web.dto.request;

import java.util.UUID;

public record PublicationRequest(
        String body,
        UUID authorId
) { }

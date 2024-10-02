package com.sci_all.demo.web.dto.response;

import java.util.UUID;

public record StreamResponse(
        UUID uuid,
        UUID streamToken,
        Long viewersCount,
        Integer likesCount,
        UUID publicationId
) { }

package com.sci_all.demo.web.dto.response;

import java.time.LocalDate;
import java.util.UUID;

public record PublicationResponse(
        UUID id,
        String content,
        LocalDate deletedAt,
        UUID authorId
) { }

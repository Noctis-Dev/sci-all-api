package com.sci_all.demo.service;

import com.sci_all.demo.web.dto.BaseResponse;
import com.sci_all.demo.web.dto.request.PublicationRequest;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface IPublicationService {

    BaseResponse getPublications(Pageable pageable);
    BaseResponse getPublicationById(UUID publicationId);
    BaseResponse createPublication(PublicationRequest request, UUID userId);
    BaseResponse updatePublication(PublicationRequest request, UUID publicationId);
    BaseResponse publicationLike(UUID publicationId, UUID userId);
    BaseResponse deletePublication(UUID publicationId);

}

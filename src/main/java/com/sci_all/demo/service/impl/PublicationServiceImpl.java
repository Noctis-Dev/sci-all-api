package com.sci_all.demo.service.impl;

import com.sci_all.demo.persistance.entities.Publication;
import com.sci_all.demo.persistance.entities.User;
import com.sci_all.demo.persistance.repositories.PublicationRepository;
import com.sci_all.demo.service.IPublicationLikeService;
import com.sci_all.demo.service.IPublicationService;
import com.sci_all.demo.service.IUserService;
import com.sci_all.demo.utils.UUIDUtils;
import com.sci_all.demo.web.dto.BaseResponse;
import com.sci_all.demo.web.dto.request.PublicationRequest;
import com.sci_all.demo.web.dto.response.PublicationResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class PublicationServiceImpl implements IPublicationService {

    @Autowired
    private PublicationRepository repository;

    @Autowired
    private IUserService userService;

    @Autowired
    private IPublicationLikeService likeService;

    @Override
    public BaseResponse getPublications(Pageable pageable) {
        Page<Publication> publications = repository.findAll(pageable);
        Page<PublicationResponse> publicationResponses = publications.map(this::toPublicationResponse);

        return BaseResponse.builder()
                .data(publicationResponses)
                .message("Publications")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .status(200).build();
    }

    @Override
    public BaseResponse getPublicationById(UUID publicationId) {
        Publication publication = repository.findByUuid(publicationId)
                .orElseThrow(EntityNotFoundException::new);

        return BaseResponse.builder()
                .data(toPublicationResponse(publication))
                .message("Publication")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .status(200).build();
    }

    @Override
    public BaseResponse createPublication(PublicationRequest request) {
        Publication publication = toPublication(request);

        publication.setAuthor(userService.findOneAndEnsureExists(request.authorId()));
        publication.setUuid(UUIDUtils.generateUniqueUUID(repository));
        Publication savedPublication = repository.save(publication);

        return BaseResponse.builder()
                .data(toPublicationResponse(savedPublication))
                .message("Publication created successfully")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .status(200).build();
    }

    @Override
    public BaseResponse updatePublication(PublicationRequest request, UUID publicationId) {
        Publication publication = repository.findByUuid(publicationId)
                .orElseThrow(EntityNotFoundException::new);

        update(publication, request);
        Publication updatedPublication = repository.save(publication);

        return BaseResponse.builder()
                .data(toPublicationResponse(updatedPublication))
                .message("Publication updated successfully")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .status(200).build();
    }

    @Override
    public BaseResponse publicationLike(UUID publicationId, UUID userId) {
        Publication publication = repository.findByUuid(publicationId)
                .orElseThrow(EntityNotFoundException::new);

        User user = userService.findOneAndEnsureExists(userId);
        likeService.createPublicationLike(publication, user);

        return BaseResponse.builder()
                .data(null)
                .message("Publication liked successfully")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .status(200).build();
    }

    @Override
    public BaseResponse deletePublication(UUID publicationId) {
        Publication publication = repository.findByUuid(publicationId)
                .orElseThrow(EntityNotFoundException::new);

        publication.setDeletedAt(LocalDate.now());

        return BaseResponse.builder()
                .data(repository.save(publication))
                .message("Publication deleted successfully")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .status(200).build();
    }

    private void update(Publication publication, PublicationRequest request) {
        publication.setBody(request.body());
    }

    private Publication toPublication(PublicationRequest request) {
        Publication publication = new Publication();

        publication.setBody(request.body());

        return publication;
    }

    private PublicationResponse toPublicationResponse(Publication publication) {
        return new PublicationResponse(
                publication.getUuid(),
                publication.getBody(),
                publication.getDeletedAt(),
                publication.getAuthor().getUuid()
        );
    }

}

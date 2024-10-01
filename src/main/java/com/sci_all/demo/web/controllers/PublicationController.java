package com.sci_all.demo.web.controllers;

import com.sci_all.demo.service.IPublicationService;
import com.sci_all.demo.web.dto.BaseResponse;
import com.sci_all.demo.web.dto.request.PublicationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("publication")
public class PublicationController {

    @Autowired
    private IPublicationService service;

    @GetMapping
    public ResponseEntity<BaseResponse> getPublications(@RequestParam(required = true) int page,
                                                        @RequestParam(required = true) int size) {

        Pageable pageable = PageRequest.of(page, size);
        return service.getPublications(pageable).apply();
    }

    @GetMapping("/{publicationId}")
    public ResponseEntity<BaseResponse> getPublicationById(@PathVariable UUID publicationId) {
        return service.getPublicationById(publicationId).apply();
    }

    @PostMapping
    public ResponseEntity<BaseResponse> createPublication(@RequestBody PublicationRequest request) {
        return service.createPublication(request).apply();
    }

    @PostMapping("{publicationId}/like")
    public ResponseEntity<BaseResponse> publicationLike(@PathVariable UUID publicationId,
                                                        @RequestParam(required = true) UUID userId) {
        return service.publicationLike(publicationId, userId).apply();
    }

    @PutMapping("/{publicationId}")
    public ResponseEntity<BaseResponse> updatePublication(@RequestBody PublicationRequest request,
                                                          @PathVariable UUID publicationId) {
        return service.updatePublication(request, publicationId).apply();
    }

    @DeleteMapping("/{publicationId}")
    public ResponseEntity<BaseResponse> deletePublication(@PathVariable UUID publicationId) {
        return service.deletePublication(publicationId).apply();
    }


}

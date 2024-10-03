package com.sci_all.demo.service.impl;

import com.sci_all.demo.persistance.entities.Stream;
import com.sci_all.demo.persistance.repositories.StreamRepository;
import com.sci_all.demo.service.IPublicationService;
import com.sci_all.demo.service.IStreamService;
import com.sci_all.demo.utils.UUIDUtils;
import com.sci_all.demo.web.dto.BaseResponse;
import com.sci_all.demo.web.dto.response.StreamResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StreamServiceImpl implements IStreamService {

    @Autowired
    private StreamRepository repository;

    @Autowired
    private IPublicationService publicationService;

    @Override
    public BaseResponse getStream(UUID streamId) {
        Stream stream = findOneAndEnsureExist(streamId);

        return BaseResponse.builder()
                .data(stream)
                .message("Stream retrieved successfully")
                .success(true)
                .status(200)
                .httpStatus(HttpStatus.OK).build();
    }

    @Override
    public BaseResponse createStream(UUID publicationId) {
        Stream stream = new Stream();

        stream.setUuid(UUIDUtils.generateUniqueUUID(repository));
        stream.setStreamToken(UUIDUtils.generateUniqueUUID(repository));
        stream.setPublication(publicationService.findOneAndEnsureExist(publicationId));
        stream.setLikesCount(0);
        stream.setViewersCount(0L);
        Stream savedStream = repository.save(stream);


        return BaseResponse.builder()
                .data(toStreamResponse(savedStream))
                .message("Stream created successfully")
                .success(Boolean.TRUE)
                .status(200)
                .httpStatus(HttpStatus.OK).build();
    }

    @Override
    public Stream findOneAndEnsureExist(UUID streamId) {
        return repository.findByUuid(streamId).orElseThrow(EntityNotFoundException::new);
    }

    private StreamResponse toStreamResponse(Stream stream) {
        return new StreamResponse(
                stream.getUuid(),
                stream.getStreamToken(),
                stream.getViewersCount(),
                stream.getLikesCount(),
                stream.getPublication().getUuid()
        );
    }
}

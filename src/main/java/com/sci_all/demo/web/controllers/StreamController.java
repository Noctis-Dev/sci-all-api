package com.sci_all.demo.web.controllers;

import com.sci_all.demo.service.IStreamService;
import com.sci_all.demo.web.dto.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("stream")
public class StreamController {

    @Autowired
    private IStreamService service;

    @GetMapping
    public ResponseEntity<BaseResponse> getStream(UUID streamId) {
        return service.getStream(streamId).apply();
    }

    @PostMapping
    public ResponseEntity<BaseResponse> createStream(UUID publicationId) {
        return service.createStream(publicationId).apply();
    }

}

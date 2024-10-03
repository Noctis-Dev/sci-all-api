package com.sci_all.demo.service;

import com.sci_all.demo.web.dto.BaseResponse;

import java.util.UUID;

public interface IStreamService {

    BaseResponse getStream(UUID streamId);
    BaseResponse createStream(UUID publicationId);

}

package com.sci_all.demo.service;

import com.sci_all.demo.web.dto.BaseResponse;
import com.sci_all.demo.web.dto.request.DonationRequest;

import java.util.UUID;

public interface IDonationService {

    BaseResponse donateToStream(UUID streamId, UUID authorId, DonationRequest request);

}

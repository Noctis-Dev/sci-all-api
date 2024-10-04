package com.sci_all.demo.web.controllers;

import com.sci_all.demo.service.IDonationService;
import com.sci_all.demo.web.dto.BaseResponse;
import com.sci_all.demo.web.dto.request.DonationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("donation")
public class DonationController {

    @Autowired
    private IDonationService service;

    @PostMapping
    public ResponseEntity<BaseResponse> createDonation(@RequestBody DonationRequest request) {
        return service.donateToStream(request.streamId(), request.authorId(), request).apply();
    }

}

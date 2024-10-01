package com.sci_all.demo.web.controllers;

import com.sci_all.demo.service.IJwtService;
import com.sci_all.demo.web.dto.BaseResponse;
import com.sci_all.demo.web.dto.request.JwtRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("jwt")
public class JwtController {

    @Autowired
    private IJwtService service;

    @PostMapping
    public ResponseEntity<BaseResponse> refreshToken(@RequestBody JwtRequest request) {
        return service.refreshToken(request.refreshToken()).apply();
    }

}

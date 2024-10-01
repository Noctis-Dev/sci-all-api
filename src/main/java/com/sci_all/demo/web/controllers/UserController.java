package com.sci_all.demo.web.controllers;

import com.sci_all.demo.service.IUserService;
import com.sci_all.demo.web.dto.BaseResponse;
import com.sci_all.demo.web.dto.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService service;

    @GetMapping("{userId}")
    public ResponseEntity<BaseResponse> verifyUser(@PathVariable UUID userId, @RequestParam String token) {
        return service.verifyUser(token, userId).apply();
    }

    @PostMapping
    public ResponseEntity<BaseResponse> createUser(@RequestBody UserRequest request) {
        return service.createUser(request).apply();
    }

}

package com.sci_all.demo.web.controllers;

import com.sci_all.demo.service.IUserService;
import com.sci_all.demo.web.dto.BaseResponse;
import com.sci_all.demo.web.dto.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("user") // http://localhost:8080/api/v1/user
public class UserController {

    @Autowired
    @Qualifier("userServiceImpl")
    private IUserService service;

    // http://localhost:8080/api/v1/user/asdf-asdfs-sdf3e-ssdfv
    @GetMapping("{userId}")
    public ResponseEntity<BaseResponse> getUserById(@PathVariable UUID userId) {
        return service.getUserById(userId).apply();
    }

    @GetMapping("verify/{userId}")
    public ResponseEntity<BaseResponse> verifyUser(@PathVariable UUID userId, @RequestParam String token) {
        return service.verifyUser(token, userId).apply();
    }

    @PostMapping
    public ResponseEntity<BaseResponse> createUser(@RequestBody UserRequest request) {
        return service.createUser(request).apply();
    }

    @PutMapping("{userId}")
    public ResponseEntity<BaseResponse> updateUser(@PathVariable UUID userId,
                                                   @RequestBody UserRequest request) {
        return service.updateUser(userId, request).apply();
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<BaseResponse> deleteUser(@PathVariable UUID userId) {
        return service.deleteUser(userId).apply();
    }

}

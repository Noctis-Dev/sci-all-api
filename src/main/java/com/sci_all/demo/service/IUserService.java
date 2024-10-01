package com.sci_all.demo.service;

import com.sci_all.demo.persistance.entities.User;
import com.sci_all.demo.web.dto.BaseResponse;
import com.sci_all.demo.web.dto.request.UserRequest;

import java.util.UUID;

public interface IUserService {
    BaseResponse createUser(UserRequest request);
    BaseResponse verifyUser(String token, UUID userId);
    User findByEmail(String email);
}

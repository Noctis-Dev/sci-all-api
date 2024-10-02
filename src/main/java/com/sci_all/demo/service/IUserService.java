package com.sci_all.demo.service;

import com.sci_all.demo.persistance.entities.User;
import com.sci_all.demo.web.dto.BaseResponse;
import com.sci_all.demo.web.dto.request.UserRequest;

import java.util.UUID;

public interface IUserService {

    BaseResponse getUserById(UUID userId);
    BaseResponse createUser(UserRequest request);
    BaseResponse verifyUser(String token, UUID userId);
    BaseResponse updateUser(UUID userId, UserRequest request);
    BaseResponse deleteUser(UUID userId);

    User findByEmail(String email);
    User findOneAndEnsureExists(UUID userId);

}

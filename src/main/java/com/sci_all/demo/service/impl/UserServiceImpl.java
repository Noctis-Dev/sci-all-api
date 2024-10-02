package com.sci_all.demo.service.impl;

import com.sci_all.demo.persistance.entities.User;
import com.sci_all.demo.persistance.repositories.UserRepository;
import com.sci_all.demo.service.IRoleService;
import com.sci_all.demo.service.ITwilioService;
import com.sci_all.demo.service.IUserService;
import com.sci_all.demo.utils.UUIDUtils;
import com.sci_all.demo.web.dto.BaseResponse;
import com.sci_all.demo.web.dto.request.UserRequest;
import com.sci_all.demo.web.dto.response.UserResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private ITwilioService twilioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public BaseResponse getUserById(UUID userId) {
        User user = repository.findByUuidAndDeletedAtEmpty(userId)
                .orElseThrow(EntityNotFoundException::new);

        return BaseResponse.builder()
                .data(toUserResponse(user))
                .message("User found successfully")
                .success(true)
                .status(200)
                .httpStatus(HttpStatus.OK).build();
    }

    @Override
    public BaseResponse createUser(UserRequest request) {
        User user = toUser(request);

        user.setRole(roleService.findRoleByName("ESTUDIANTE"));
        UUID userUuid = UUIDUtils.generateUniqueUUID(repository);
        user.setUuid(userUuid);
        user.setVerifyToken(generateVerifyCode());

        twilioService.sendVerificationCode(user.getPhoneNumber(), user.getVerifyToken());

        return BaseResponse.builder()
                .data(toUserResponse(repository.save(user)))
                .message("User created successfully with id: " + user.getUuid())
                .success(true)
                .status(200)
                .httpStatus(HttpStatus.OK).build();
    }

    @Override
    public BaseResponse verifyUser(String token, UUID userId) {
        User user = repository.findByUuidAndVerifyToken(userId, token)
                .orElseThrow(EntityNotFoundException::new);

        user.setVerified(true);
        repository.save(user);

        return BaseResponse.builder()
                .data(toUserResponse(user))
                .message("User verified successfully")
                .success(true)
                .status(200)
                .httpStatus(HttpStatus.OK).build();
    }

    @Override
    public BaseResponse updateUser(UUID userId, UserRequest request) {
        User user = findOneAndEnsureExists(userId);

        update(user, request);
        User updatedUser = repository.save(user);

        return BaseResponse.builder()
                .data(toUserResponse(updatedUser))
                .message("User updated successfully")
                .success(true)
                .status(200)
                .httpStatus(HttpStatus.OK).build();
    }

    @Override
    public BaseResponse deleteUser(UUID userId) {
        User user = findOneAndEnsureExists(userId);
        user.setDeletedAt(LocalDate.now());

        return BaseResponse.builder()
                .data(toUserResponse(repository.save(user)))
                .message("User deleted successfully")
                .success(true)
                .status(200)
                .httpStatus(HttpStatus.OK).build();
    }

    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public User findOneAndEnsureExists(UUID userId) {
        return repository.findByUuid(userId).orElseThrow(EntityNotFoundException::new);
    }

    private void update(User user, UserRequest request) {
        user.setUsername(request.username());
        user.setEmail(request.email());
        user.setPhoneNumber(request.phoneNumber());
        user.setPassword(passwordEncoder.encode(request.password()));
    }

    private User toUser(UserRequest request) {
        User user = new User();

        user.setUsername(request.username());
        user.setEmail(request.email());
        user.setPhoneNumber(request.phoneNumber());
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setVerified(false);
        user.setCreatedAt(LocalDate.now());
        user.setDeletedAt(null);

        return user;
    }

    private UserResponse toUserResponse(User user) {
        return new UserResponse(
                user.getUuid(),
                user.getRole().getName(),
                user.getUsername(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getCreatedAt(),
                user.getDeletedAt()
        );
    }

    public static String generateVerifyCode() {
        return String.valueOf((int) (Math.random() * 9000) + 1000);
    }
}

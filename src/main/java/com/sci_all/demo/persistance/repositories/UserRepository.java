package com.sci_all.demo.persistance.repositories;

import com.sci_all.demo.persistance.entities.User;
import com.sci_all.demo.persistance.repositories.base.IBaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends IBaseRepository<User, Long> {

    Optional<User> findByUuidAndVerifyToken(UUID userUuid, String verifyToken);
    Optional<User> findByEmail(String email);

}
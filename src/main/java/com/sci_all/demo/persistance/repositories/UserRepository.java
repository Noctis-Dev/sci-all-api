package com.sci_all.demo.persistance.repositories;

import com.sci_all.demo.persistance.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
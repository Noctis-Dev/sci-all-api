package com.sci_all.demo.persistance.repositories;

import com.sci_all.demo.persistance.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
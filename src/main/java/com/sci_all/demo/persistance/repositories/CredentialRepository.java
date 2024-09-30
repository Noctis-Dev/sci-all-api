package com.sci_all.demo.persistance.repositories;

import com.sci_all.demo.persistance.entities.Credential;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialRepository extends JpaRepository<Credential, Long> {
}
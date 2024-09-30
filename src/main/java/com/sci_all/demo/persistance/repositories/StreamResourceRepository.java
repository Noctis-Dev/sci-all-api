package com.sci_all.demo.persistance.repositories;

import com.sci_all.demo.persistance.entities.StreamResource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreamResourceRepository extends JpaRepository<StreamResource, Long> {
}
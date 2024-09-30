package com.sci_all.demo.persistance.repositories;

import com.sci_all.demo.persistance.entities.PublicationResource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicationResourceRepository extends JpaRepository<PublicationResource, Long> {
}
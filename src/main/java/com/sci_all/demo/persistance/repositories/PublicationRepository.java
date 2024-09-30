package com.sci_all.demo.persistance.repositories;

import com.sci_all.demo.persistance.entities.Publication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicationRepository extends JpaRepository<Publication, Long> {
}
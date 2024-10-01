package com.sci_all.demo.persistance.repositories;

import com.sci_all.demo.persistance.entities.Publication;
import com.sci_all.demo.persistance.repositories.base.IBaseRepository;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface PublicationRepository extends IBaseRepository<Publication, Long> {

    @NonNull
    Page<Publication> findAll(@NonNull Pageable pageable);

    Optional<Publication> findByUuid(UUID publicationId);

}
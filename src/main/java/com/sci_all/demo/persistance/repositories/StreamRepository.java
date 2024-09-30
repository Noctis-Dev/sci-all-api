package com.sci_all.demo.persistance.repositories;

import com.sci_all.demo.persistance.entities.Stream;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreamRepository extends JpaRepository<Stream, Long> {
}
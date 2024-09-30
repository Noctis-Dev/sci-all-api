package com.sci_all.demo.persistance.repositories;

import com.sci_all.demo.persistance.entities.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
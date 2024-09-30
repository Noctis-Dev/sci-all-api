package com.sci_all.demo.persistance.repositories;

import com.sci_all.demo.persistance.entities.FlywaySchemaHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlywaySchemaHistoryRepository extends JpaRepository<FlywaySchemaHistory, Integer> {
}
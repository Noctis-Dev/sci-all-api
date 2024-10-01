package com.sci_all.demo.persistance.repositories;

import com.sci_all.demo.persistance.entities.StreamLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreamLikeRepository extends JpaRepository<StreamLike, Long> {
}
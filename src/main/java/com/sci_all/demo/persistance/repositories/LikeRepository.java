package com.sci_all.demo.persistance.repositories;

import com.sci_all.demo.persistance.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
}
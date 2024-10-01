package com.sci_all.demo.persistance.repositories;

import com.sci_all.demo.persistance.entities.CommentLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentLikeRepository extends JpaRepository<CommentLike, Long> {
}
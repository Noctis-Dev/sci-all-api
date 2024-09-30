package com.sci_all.demo.persistance.repositories;

import com.sci_all.demo.persistance.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
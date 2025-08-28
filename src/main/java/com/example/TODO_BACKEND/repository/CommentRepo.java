package com.example.TODO_BACKEND.repository;

import com.example.TODO_BACKEND.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment,Long> {
}

package com.example.TODO_BACKEND.repository;

import com.example.TODO_BACKEND.entity.Category;
import com.example.TODO_BACKEND.entity.Post;
import com.example.TODO_BACKEND.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,Long> {

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
}

package com.example.TODO_BACKEND.repository;

import com.example.TODO_BACKEND.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepo extends JpaRepository<User,Long> {

//    Example<? extends User> id(Long id);
}

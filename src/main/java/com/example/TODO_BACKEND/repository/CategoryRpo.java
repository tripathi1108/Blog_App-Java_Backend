package com.example.TODO_BACKEND.repository;

import com.example.TODO_BACKEND.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRpo extends JpaRepository<Category,Long> {
}

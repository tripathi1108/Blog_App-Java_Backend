package com.example.TODO_BACKEND.service;

import com.example.TODO_BACKEND.Dto.CategoryDto;

import java.util.List;

public interface categoryService {


    //create
    CategoryDto createCategory(CategoryDto categoryDto);
    //update
    CategoryDto updateCategory(CategoryDto categoryDto,Long categoryId);
    //delete
    public void deleteCategory(Long categoryId);
    //get
    public CategoryDto getCategory(Long categoryId);
    //getall
    List<CategoryDto> getAllCategory();


}

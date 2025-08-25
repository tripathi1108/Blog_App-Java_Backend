package com.example.TODO_BACKEND.serviceImp;

import com.example.TODO_BACKEND.Dto.CategoryDto;
import com.example.TODO_BACKEND.entity.Category;
import com.example.TODO_BACKEND.exceptions.ResourceNotFoundException;
import com.example.TODO_BACKEND.repository.CategoryRpo;
import com.example.TODO_BACKEND.service.categoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class categoryServiceImp implements categoryService {

    private final CategoryRpo categoryRpo;
    private final ModelMapper modelMapper;

    // ✅ Constructor Injection (recommended)
    @Autowired
    public categoryServiceImp(CategoryRpo categoryRpo, ModelMapper modelMapper) {
        this.categoryRpo = categoryRpo;
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category cat = modelMapper.map(categoryDto, Category.class);
        Category saved = categoryRpo.save(cat);
        return modelMapper.map(saved, CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Long categoryId) {
        Category cat = categoryRpo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", categoryId));
        cat.setCategoryTitle(categoryDto.getCategoryTitle());
        cat.setCategoryDescription(categoryDto.getCategoryDescription());
        Category updated = categoryRpo.save(cat);
        return modelMapper.map(updated, CategoryDto.class);
    }

    @Override
    public void deleteCategory(Long categoryId) {
        Category cat = categoryRpo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", categoryId));
        categoryRpo.delete(cat);
    }

    @Override
    public CategoryDto getCategory(Long categoryId) {
        Category cat = categoryRpo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", categoryId));
        return modelMapper.map(cat, CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        List<Category> categories = categoryRpo.findAll();
        return categories.stream()
                .map(c -> modelMapper.map(c, CategoryDto.class))
                .collect(Collectors.toList());
    }
}

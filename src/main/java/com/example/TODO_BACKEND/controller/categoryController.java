package com.example.TODO_BACKEND.controller;


import com.example.TODO_BACKEND.Dto.CategoryDto;
import com.example.TODO_BACKEND.payloads.ApiResponse;
import com.example.TODO_BACKEND.service.categoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class categoryController {
    @Autowired
    private categoryService categoryService;
    //create
    @PostMapping("/new")
    public ResponseEntity<CategoryDto>createCategory(@RequestBody CategoryDto categoryDto){
            CategoryDto createCategory = this.categoryService.createCategory(categoryDto);
            return  new ResponseEntity<CategoryDto>(createCategory, HttpStatus.CREATED);
    }

    //update
    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto>updateCategory(@RequestBody CategoryDto categoryDto,@PathVariable Long categoryId){
        CategoryDto updatedCategory = this.categoryService.updateCategory(categoryDto,categoryId);
        return  ResponseEntity.ok(updatedCategory);
    }
    //delete
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse>deleteCategory(@PathVariable Long categoryId){
        this.categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(new ApiResponse("category is deleted successfully !!",false),HttpStatus.OK);
    }
    //get
    @GetMapping("/{categoryId}")
    public  ResponseEntity<CategoryDto> getCategory(@PathVariable Long categoryId)
    {
        CategoryDto categoryDto = this.categoryService.getCategory(categoryId);
        return new ResponseEntity<CategoryDto>(categoryDto,HttpStatus.OK);
    }
    //getall
    @GetMapping("/")
    
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        List<CategoryDto> categories = this.categoryService.getAllCategory();
        return ResponseEntity.ok(categories);
    }


}

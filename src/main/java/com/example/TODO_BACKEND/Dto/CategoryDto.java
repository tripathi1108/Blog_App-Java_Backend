package com.example.TODO_BACKEND.Dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
    private Long categoryId;
    private String categoryTitle;
    private String categoryDescription;

}

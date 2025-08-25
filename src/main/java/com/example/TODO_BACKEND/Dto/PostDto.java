package com.example.TODO_BACKEND.Dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
public class PostDto {


    private String title;
    private String content;
    private Date addedDate;
    private String imageName;


    private CategoryDto category;
    private UserDto user;



}

package com.example.TODO_BACKEND.Dto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor


public class CommentDto {


    private Long commentId;
    private String Comment;

    private String postTitle;
    private String userName;
}

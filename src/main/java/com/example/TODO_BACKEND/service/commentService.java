package com.example.TODO_BACKEND.service;

import com.example.TODO_BACKEND.Dto.CommentDto;

import java.util.List;

public interface commentService {


    //create
    CommentDto addComment(CommentDto commentDto,Long userId,Long postId);

    //update
    CommentDto updateComment(CommentDto commentDto,Long commentId);

    //delete
    void deleteComment(Long commentId);
    //getall
    List<CommentDto> getAllComment();




}

package com.example.TODO_BACKEND.controller;

import com.example.TODO_BACKEND.Dto.CommentDto;
import com.example.TODO_BACKEND.payloads.ApiResponse;
import com.example.TODO_BACKEND.service.commentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class commentController {

    @Autowired
    private commentService commentService;


    //create
    @PostMapping("/user/{userId}/post/{postId}/new")
    public ResponseEntity<CommentDto> addComment(@RequestBody CommentDto commentDto, @PathVariable Long userId,@PathVariable Long postId)
    {
        CommentDto comment=this.commentService.addComment(commentDto,userId,postId);
        return  new ResponseEntity<>(comment, HttpStatus.OK);
    }
    //update
    @PutMapping("/{commentId}")
    public ResponseEntity<CommentDto> updateComment(@RequestBody CommentDto commen,@PathVariable Long commentId){
        CommentDto commentDto= this.commentService.updateComment(commen, commentId);
        return ResponseEntity.ok(commentDto);
    }
    //delete
    @DeleteMapping("/{commentId}")
    public  ResponseEntity<ApiResponse> deleteComment(Long commentId)
    {
         this.commentService.deleteComment(commentId);
        return new ResponseEntity<>(new ApiResponse("comment is deleted successfully !!",false),HttpStatus.OK);

    }
    // getall
    @GetMapping("/all")
    public ResponseEntity<List<CommentDto>>getAllComment()
    {
        List<CommentDto> commentDtos = this.commentService.getAllComment();
        return ResponseEntity.ok(commentDtos);
    }

}

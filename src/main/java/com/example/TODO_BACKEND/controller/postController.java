package com.example.TODO_BACKEND.controller;

import com.example.TODO_BACKEND.Dto.PostDto;

import com.example.TODO_BACKEND.payloads.ApiResponse;
import com.example.TODO_BACKEND.service.postService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")

public class postController {
    @Autowired
    private postService postService;


    //create
    @PostMapping("/user/{userId}/category/{categoryId}/new")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Long userId , @PathVariable Long categoryId)
    {
        PostDto newPost = this.postService.createPost(postDto,userId,categoryId);
      return  new ResponseEntity<PostDto>(newPost, HttpStatus.CREATED);
    }

    //update
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Long id)
    {
        PostDto updatedPost= this.postService.updatePost(postDto, id);
        return  ResponseEntity.ok(updatedPost);
    }

    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable Long id)
    {
        this.postService.deletePost(id);
        return new ResponseEntity<>(new ApiResponse("Post Deleted Successfully",true),HttpStatus.OK);

    }

    //getall
    @GetMapping("/")
    public ResponseEntity<List<PostDto>> getAllPosts()
    {
        List<PostDto> postDto = this.postService.getAll();
        return new ResponseEntity<>(postDto,HttpStatus.OK);
    }
    //getById
    @GetMapping("/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Long postId)
    {
        PostDto postDto = this.postService.getPostById(postId);
        return new ResponseEntity<>(postDto,HttpStatus.OK);
    }

    //getbyUser
    @GetMapping("users/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Long userId)
    {
        List<PostDto> posts = this.postService.getPostByUser(userId);
        return new ResponseEntity<>(posts,HttpStatus.OK);
    }

    //get By Category

    //getbyUser
    @GetMapping("category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Long categoryId)
    {
        List<PostDto> posts = this.postService.getPostsByCategory(categoryId);
        return new ResponseEntity<>(posts,HttpStatus.OK);
    }

}

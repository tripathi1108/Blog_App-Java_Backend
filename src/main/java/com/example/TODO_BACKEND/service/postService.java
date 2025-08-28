package com.example.TODO_BACKEND.service;

import com.example.TODO_BACKEND.Dto.PostDto;
import com.example.TODO_BACKEND.entity.Post;
import com.example.TODO_BACKEND.payloads.PostResponse;

import java.util.List;

public interface postService {

    //create
    PostDto createPost(PostDto postDto, Long categoryId,Long userId);

    //update
    PostDto updatePost(PostDto postDto,Long postId);

    //delete
    void deletePost(Long postId);

    //getById
    PostDto getPostById(Long id);

    //getAll
    PostResponse getAll(Integer pageNumber, Integer pageSize);

    //get all post by category
    List<PostDto> getPostsByCategory(Long categoryId);

    //get all post by user
    List<PostDto> getPostByUser(Long userId);

  //  search Post
    List<Post> searchPosts(String userId);

}

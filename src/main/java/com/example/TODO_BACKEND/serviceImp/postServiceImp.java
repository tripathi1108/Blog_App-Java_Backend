package com.example.TODO_BACKEND.serviceImp;

import com.example.TODO_BACKEND.Dto.PostDto;
import com.example.TODO_BACKEND.entity.Category;
import com.example.TODO_BACKEND.entity.Post;
import com.example.TODO_BACKEND.entity.User;
import com.example.TODO_BACKEND.exceptions.ResourceNotFoundException;
import com.example.TODO_BACKEND.repository.CategoryRpo;
import com.example.TODO_BACKEND.repository.PostRepo;
import com.example.TODO_BACKEND.repository.userRepo;
import com.example.TODO_BACKEND.service.postService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public  class postServiceImp implements postService {
    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private userRepo userRepo;

    @Autowired
    private CategoryRpo categoryRepo;

    //create
    @Override

    public PostDto createPost(PostDto postDto, Long userId, Long categoryId) {

        User user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
        Category category = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

        Post p1 = this.modelMapper.map(postDto, Post.class);

        // If no imageName provided, set default
        if (postDto.getImageName() == null || postDto.getImageName().isBlank()) {
            p1.setImageName("default.png");
        }

        p1.setAddedDate(new Date());
        p1.setCategory(category);
        p1.setUser(user);

        Post saved = this.postRepo.save(p1);
        return this.modelMapper.map(saved, PostDto.class);
    }


    //update
    @Override
    public PostDto updatePost(PostDto postDto,Long postId){
        Post posts = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "postId", postId));
            posts.setTitle(postDto.getTitle());
            posts.setContent(postDto.getContent());
            posts.setImageName(postDto.getImageName());
            Post savedPost  = this.postRepo.save(posts);
        return this.modelMapper.map(savedPost, PostDto.class);
    }

    //delete
    @Override
    public void deletePost(Long postId){
        Post p = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","postId:", postId));
        this.postRepo.delete(p);

    }


    //getById
    @Override
   public PostDto getPostById(Long id){

        Post post= this.postRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post","postId", id));
        PostDto postDto = this.modelMapper.map(post,PostDto.class);
        return postDto;
   }

    //getAll
    @Override
   public List<PostDto> getAll(

    )
    {
        List<Post>posts= this.postRepo.findAll();
        List<PostDto>postDtos = posts.stream().map((post) -> this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }


    //get all post by category
    @Override
    public List<PostDto> getPostsByCategory(Long categoryId){
        Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","categoryId",categoryId));
        List<Post>posts = this.postRepo.findByCategory(cat);
        List<PostDto> postDtos=  posts.stream().map((post) -> this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    //get all post by user
    @Override
   public List<PostDto> getPostByUser(Long userId)
    {
        User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","userId",userId));
        List<Post>posts = this.postRepo.findByUser(user);
        List<PostDto>postDtos =  posts.stream().map((post) -> this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }
    //  search Post
    @Override
    public List<Post> searchPosts(String userId){
        return null;
    }





}

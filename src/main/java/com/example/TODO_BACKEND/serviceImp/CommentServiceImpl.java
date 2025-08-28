package com.example.TODO_BACKEND.serviceImp;

import com.example.TODO_BACKEND.Dto.CommentDto;
import com.example.TODO_BACKEND.entity.Comment;
import com.example.TODO_BACKEND.entity.Post;
import com.example.TODO_BACKEND.entity.User;
import com.example.TODO_BACKEND.exceptions.ResourceNotFoundException;
import com.example.TODO_BACKEND.repository.CommentRepo;
import com.example.TODO_BACKEND.repository.PostRepo;
import com.example.TODO_BACKEND.repository.userRepo;
import com.example.TODO_BACKEND.service.commentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements commentService {

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private userRepo userRepo;

    // Create
    @Override

    public CommentDto addComment(CommentDto commentDto, Long userId, Long postId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
        Post post = this.postRepo.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "postId", postId));

        Comment comment = modelMapper.map(commentDto, Comment.class);
        comment.setUser(user);
        comment.setPost(post);

        Comment savedComment = this.commentRepo.save(comment);

        // build DTO manually
        CommentDto response = new CommentDto();
        response.setCommentId(savedComment.getCommentId());
        response.setComment(savedComment.getComment());
        response.setUserName(user.getName());   // <-- only username
        response.setPostTitle(post.getTitle());     // <-- only title

        return response;
    }


    // Update
    @Override
    public CommentDto updateComment( CommentDto commentDto,Long commentId) {
        Comment comment = this.commentRepo.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "commentId", commentId));

        comment.setComment(commentDto.getComment());
        Comment updatedComment = this.commentRepo.save(comment);

        return this.modelMapper.map(updatedComment, CommentDto.class);
    }

    // Delete
    @Override
    public void deleteComment(Long commentId) {
        Comment comment = this.commentRepo.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "commentId", commentId));
        this.commentRepo.delete(comment);
    }

    // Get All
    @Override
    public List<CommentDto> getAllComment() {
        List<Comment> comments = this.commentRepo.findAll();
        return comments.stream()
                .map(c -> modelMapper.map(c, CommentDto.class))
                .collect(Collectors.toList());
    }
}

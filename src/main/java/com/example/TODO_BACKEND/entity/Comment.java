package com.example.TODO_BACKEND.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long commentId;
    private String comment;

    @ManyToOne
   private Post post;
    @ManyToOne
    private User user;



}

package com.example.TODO_BACKEND.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor



public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length=100)
    private String name;
    @Column(nullable=false, length=100)


    private String email;
    @Column(nullable=false, length=100)
    private String password;
    @Column(name = "description", nullable = false,length = 300)
    private String about;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Post> post =new ArrayList<>();

}

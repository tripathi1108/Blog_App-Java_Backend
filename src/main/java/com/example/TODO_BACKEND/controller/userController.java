package com.example.TODO_BACKEND.controller;


import com.example.TODO_BACKEND.payloads.ApiResponse;
import com.example.TODO_BACKEND.service.userService;
import com.example.TODO_BACKEND.Dto.UserDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class userController {
    @Autowired
    private userService userService;

    //POST--CREATE NEW USERS
    @PostMapping("/new")
    public ResponseEntity<UserDto> createUser(@Valid  @RequestBody UserDto userDto){
    UserDto createdUserDto = this.userService.createUser(userDto);
    return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }
    //PUT--UPDATE USERS
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updatedUser(@Valid @RequestBody UserDto userDto, @PathVariable Long userId)
    {
       UserDto User = this.userService.updateUser(userDto,userId);
        return  ResponseEntity.ok(User);
    }

    //DELETE--DELETE USERS
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long userId)
    {
        this.userService.deleteUser(userId);
        return new ResponseEntity<>(new ApiResponse("User Deleted SUccessfully",true),HttpStatus.OK);
    }

    //GET--User GET
    @GetMapping("/getall")
    public ResponseEntity<List<UserDto>> getAll (){
        return ResponseEntity.ok(this.userService.getAllUsers());
    }
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long userId){
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }




}

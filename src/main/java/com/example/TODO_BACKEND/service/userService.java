package com.example.TODO_BACKEND.service;


import com.example.TODO_BACKEND.Dto.UserDto;

import java.util.List;

public interface userService {

  UserDto  createUser(UserDto user);
  UserDto updateUser(UserDto userDto,Long id);
  UserDto getUserById(Long id);
  List<UserDto> getAllUsers();
  void deleteUser(Long id);
}

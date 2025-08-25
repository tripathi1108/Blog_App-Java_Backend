package com.example.TODO_BACKEND.serviceImp;

import com.example.TODO_BACKEND.entity.User;
import com.example.TODO_BACKEND.repository.userRepo;
import com.example.TODO_BACKEND.service.userService;
import com.example.TODO_BACKEND.Dto.UserDto;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import  com.example.TODO_BACKEND.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Service
public class userServiceImp implements userService {


    @Autowired
    private userRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserDto createUser(UserDto user){
        User user1 = this.dtoToEntity(user);
        User savedUser= this.userRepo.save(user1);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Long userId) {

        User user = this.userRepo.findById(userId).orElseThrow( ()-> new ResourceNotFoundException("User","User Id",userId));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());

        // Save updated user
        User updatedUser = this.userRepo.save(user);
        return this.userToDto(updatedUser);
    }

    @Override

    public UserDto getUserById(Long userId){

        User user = this.userRepo.findById(userId).orElseThrow( ()-> new ResourceNotFoundException("User","User Id",userId));

        return this.userToDto(user);
    }

    @Override

    public List<UserDto> getAllUsers(){
       List <User> users=this.userRepo.findAll();
      List<UserDto> userDtos= users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());


        return userDtos;
    }

    public void deleteUser(Long userId){
     User user=   this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user","userId",userId));
        this.userRepo.delete(user);
    }

    private User dtoToEntity(UserDto userDto){

        User user = this.modelMapper.map(userDto,User.class);

//        user.setId(userDto.getId());
//        user.setName(userDto.getName());
//        user.setEmail(userDto.getEmail());
//        user.setPassword(userDto.getPassword());
//        user.setAbout(userDto.getAbout());


        return user;
    }

    public UserDto userToDto(User user){
        UserDto u= this.modelMapper.map(user , UserDto.class);

//        u.setId(user.getId());
//        u.setName(user.getName());
//        u.setEmail(user.getEmail());
//        u.setPassword(user.getPassword());
//        u.setAbout(user.getAbout());

        return u;
    }
}

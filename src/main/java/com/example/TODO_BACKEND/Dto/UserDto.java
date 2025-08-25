package com.example.TODO_BACKEND.Dto;


import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private Long id;
    @NotEmpty
    @Size(min=4,message = "User Name must be greater then 4 characters")
    private String name;
    @Email(message = "Email address is not valid !!")
    private String email;
    @NotEmpty
    @Size(min=6,message = "Password must have minimum 6 characters" )
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9]).+$",
            message = "Password must have at least 1 uppercase, 1 digit, and 1 special character"
    )

    private String password;
    @NotEmpty
    @Size(min=10, message = "About must contaion atleast 10 characters")
    private String about;

}

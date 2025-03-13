package org.example.coffeeshop.dto;

import lombok.Data;

@Data
public class RegisterUserRequestDto {

    private String email;
    private String password;
    private String confirmPassword;

}

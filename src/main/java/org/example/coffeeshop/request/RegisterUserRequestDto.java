package org.example.coffeeshop.request;

import lombok.Data;

@Data
public class RegisterUserRequestDto {

    private String email;
    private String password;
    private String confirmPassword;

}

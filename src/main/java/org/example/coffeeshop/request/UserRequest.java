package org.example.coffeeshop.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.coffeeshop.entity.UserType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserRequest {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private UserType userType;
}

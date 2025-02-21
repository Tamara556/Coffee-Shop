package org.example.coffeeshop.service;
import java.util.Optional;
import org.example.coffeeshop.entity.User;

public interface UserService {
    User save(User user);

    Optional<User> findByEmail(String email);

    
}

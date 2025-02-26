package org.example.coffeeshop.service;

import org.example.coffeeshop.entity.User;

import java.util.Optional;

public interface UserService {

    User save(User user);

    Optional<User> findByEmail(String email);


}

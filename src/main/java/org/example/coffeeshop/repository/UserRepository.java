package org.example.coffeeshop.repository;

import org.example.coffeeshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}

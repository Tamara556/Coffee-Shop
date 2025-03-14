package org.example.coffeeshop.service;

import org.example.coffeeshop.entity.User;
import org.example.coffeeshop.request.RegisterUserRequestDto;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

public interface UserService {

    Optional<User> findByEmail(String email);

    String createEmployee(RegisterUserRequestDto registerUserRequestDto, BindingResult result, RedirectAttributes redirectAttributes, Model model);
}

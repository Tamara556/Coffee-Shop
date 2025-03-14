package org.example.coffeeshop.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.coffeeshop.entity.User;
import org.example.coffeeshop.entity.UserType;
import org.example.coffeeshop.mapper.UserMapper;
import org.example.coffeeshop.repository.UserRepository;
import org.example.coffeeshop.request.RegisterUserRequestDto;
import org.example.coffeeshop.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public String createEmployee(RegisterUserRequestDto registerUserRequestDto, BindingResult result,
                                 RedirectAttributes redirectAttributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("user", registerUserRequestDto);
            return "register";
        }

        if (!registerUserRequestDto.getPassword().equals(registerUserRequestDto.getConfirmPassword())) {
            result.rejectValue("password", "error.userRequestDto", "Passwords do not match.");
            model.addAttribute("user", registerUserRequestDto);
            return "register";
        }

        if (registerUserRequestDto.getEmail() == null || !registerUserRequestDto.getEmail().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.(com|ru)$")) {
            result.rejectValue("email", "error.userRequestDto", "The email must be in a valid format and end with '.com' or '.ru'.");
            model.addAttribute("user", registerUserRequestDto);
            return "register";
        }

        if (!registerUserRequestDto.getPassword().matches("^[A-Z].{7,}$")) {
            result.rejectValue("password", "error.userRequestDto", "The password must start with an uppercase letter and be at least 8 characters long.");
            model.addAttribute("user", registerUserRequestDto);
            return "register";
        }

        if (findByEmail(registerUserRequestDto.getEmail()).isPresent()) {
            result.rejectValue("email", "error.userRequestDto", "An account already exists with this email.");
            model.addAttribute("user", registerUserRequestDto);
            return "register";
        }

        User user = userMapper.fromRequestDto(registerUserRequestDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setUserType(UserType.USER);
        userRepository.save(user);

        redirectAttributes.addFlashAttribute("successMessage", "Registration successful! Please log in.");
        return "redirect:/loginPage";
    }
}
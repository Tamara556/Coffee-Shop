package org.example.coffeeshop.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.coffeeshop.entity.User;
import org.example.coffeeshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @GetMapping("/loginPage")
    public String loginPage() {
        return "loginPage";
    }

    @PostMapping("/loginPage")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        Model model,
                        HttpSession session) {
        Optional<User> user = userService.findByEmail(email);

        if (user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
            session.setAttribute("user", user);
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Invalid username or password!");
            return "loginPage";
        }
    }
}
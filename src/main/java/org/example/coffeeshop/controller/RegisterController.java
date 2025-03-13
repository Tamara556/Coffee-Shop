package org.example.coffeeshop.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.coffeeshop.entity.User;
import org.example.coffeeshop.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequiredArgsConstructor
public class RegisterController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String addUser(@Valid @ModelAttribute User user,
                          @RequestParam String confirmPassword,
                          BindingResult result,
                          RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "register";
        }

        if (!user.getPassword().equals(confirmPassword)) {
            result.rejectValue("password", "error.user", "Passwords do not match.");
            return "register";
        }

        if (user.getEmail() == null || !user.getEmail().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.(com|ru)$")) {
            result.rejectValue("email", "error.user", "The email must be in a valid format and end with '.com' or '.ru'.");
            return "register";
        }

        if (user.getPassword() == null || !user.getPassword().matches("^[A-Z].{7,}$")) {
            result.rejectValue("password", "error.user", "The password must start with an uppercase letter and be at least 8 characters long.");
            return "register";
        }
        User byEmail = userService.findByEmail(user.getEmail()).orElse(null);
        if (byEmail != null) {
            result.rejectValue("email", "error.user", "An account already exists with this email.");
            return "register";
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);

        redirectAttributes.addFlashAttribute("successMessage", "Registration successful! Please log in.");

        return "redirect:/loginPage";
    }
}

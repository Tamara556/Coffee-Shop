package org.example.coffeeshop.controller;


import lombok.RequiredArgsConstructor;
import org.example.coffeeshop.request.RegisterUserRequestDto;
import org.example.coffeeshop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequiredArgsConstructor
public class RegisterController {

    private final UserService userService;

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new RegisterUserRequestDto());
        return "register";
    }

    @PostMapping("/register")
    public String addUser(@ModelAttribute("user") RegisterUserRequestDto registerUserRequestDto,
                          BindingResult result,
                          RedirectAttributes redirectAttributes,
                          Model model) {
        return userService.createEmployee(registerUserRequestDto, result, redirectAttributes, model);
    }
}
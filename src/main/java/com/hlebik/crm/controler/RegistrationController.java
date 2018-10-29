package com.hlebik.crm.controler;

import com.hlebik.crm.dto.UserDto;
import com.hlebik.crm.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class RegistrationController {
    private final UserService userService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new UserDto());
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("user") UserDto user, Model model) {
        return userService.makeRegistration(user, model);
    }

    @GetMapping("/")
    public String main(Model model) {

        return "redirect:list-customers";
    }
}

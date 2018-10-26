package com.hlebik.crm.controler;

import com.hlebik.crm.dbo.User;
import com.hlebik.crm.enumerated.Role;
import com.hlebik.crm.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
@AllArgsConstructor
public class UserController {
private final UserRepository userRepository;
    @GetMapping("/registration")
    public String registration(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }
    @PostMapping("/registration")
    public String addUser(@ModelAttribute("user") User user, Model model) {
        User userFomDb = userRepository.findByUserName(user.getUserName());
        if(userFomDb != null){
            model.addAttribute("message", "User exist");
            return "registration";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);
        return "redirect:/login";
    }
}

package com.hlebik.crm.service;

import com.hlebik.crm.converter.UserConverter;
import com.hlebik.crm.dbo.UserDbo;
import com.hlebik.crm.dto.UserDto;
import com.hlebik.crm.enumerated.Role;
import com.hlebik.crm.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Collections;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserConverter userConverter;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public String makeRegistration(@ModelAttribute("user") UserDto user, Model model) {
        UserDbo userFomDb = userRepository.findByUserName(user.getUserName());
        if (userFomDb != null) {
            model.addAttribute("message", "User exist");
            return "registration";
        }
        UserDbo userDbo = userConverter.convertToDbo(user);
        userDbo.setPassword(bCryptPasswordEncoder.encode(userDbo.getPassword()));
        userDbo.setActive(true);
        userDbo.setRoles(Collections.singleton(Role.ROLE_USER));
        userRepository.save(userDbo);
        return "redirect:/login";
    }
}

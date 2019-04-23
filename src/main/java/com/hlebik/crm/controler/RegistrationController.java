package com.hlebik.crm.controler;

import com.hlebik.crm.dto.UserDto;
import com.hlebik.crm.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RegistrationController {

    private final UserService userService;

    @GetMapping("/registration")
    public ResponseEntity<UserDto> registration() {
        return new ResponseEntity<>(new UserDto(), HttpStatus.OK);
    }

    @PostMapping("/registration")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto user) {
        return userService.makeRegistration(user);
    }
}

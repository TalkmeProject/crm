package com.hlebik.crm.service;

import com.hlebik.crm.converter.UserConverter;
import com.hlebik.crm.dbo.UserDbo;
import com.hlebik.crm.dto.UserDto;
import com.hlebik.crm.enumerated.Role;
import com.hlebik.crm.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
@AllArgsConstructor
@Configuration
public class UserService {
    private final UserRepository userRepository;
    private final UserConverter userConverter;
    //private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public ResponseEntity<UserDto> makeRegistration(final UserDto user) {
        Optional<UserDbo> userFomDb = userRepository.findByUserName(user.getUserName());
        if (userFomDb.isPresent()) {
            return new ResponseEntity<>(new UserDto(), HttpStatus.FOUND);
        } else {
            UserDbo userDbo = userConverter.convertToDbo(user);
            //  userDbo.setPassword(bCryptPasswordEncoder.encode(userDbo.getPassword()));
            userDbo.setActive(true);
            userDbo.setRoles(Collections.singleton(Role.ROLE_USER));
            UserDbo savedUser = userRepository.save(userDbo);
            return new ResponseEntity<>(userConverter.convertToDto(savedUser), HttpStatus.OK);
        }
    }


}

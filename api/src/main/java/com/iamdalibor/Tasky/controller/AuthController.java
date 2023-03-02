package com.iamdalibor.Tasky.controller;

import com.iamdalibor.Tasky.model.User;
import com.iamdalibor.Tasky.model.dto.RegisterDto;
import com.iamdalibor.Tasky.repository.UserRepository;
import com.iamdalibor.Tasky.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterDto registerDto) {

        if(userRepository.existsByEmail(registerDto.getEmail())) {
            return new ResponseEntity<>("Email is already taken", HttpStatus.BAD_REQUEST);
        }

        if (!registerDto.getPassword().equals(registerDto.getRepeatPassword())) {
            return new ResponseEntity<>("Passwords do not match", HttpStatus.BAD_REQUEST);
        }

        User user = new User(registerDto.getEmail(), passwordEncoder.encode(registerDto.getPassword()), registerDto.getFName(), registerDto.getLName());

        userRepository.save(user);
//        userService.register(registerDto.getEmail(), registerDto.getPassword(), registerDto.getRepeatPassword(), registerDto.getFName(), registerDto.getLName());

        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }
}
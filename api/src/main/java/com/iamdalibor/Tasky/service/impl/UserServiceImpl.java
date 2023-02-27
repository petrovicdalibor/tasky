package com.iamdalibor.Tasky.service.impl;

import com.iamdalibor.Tasky.model.User;
import com.iamdalibor.Tasky.model.exceptions.InvalidUsernameOrPasswordException;
import com.iamdalibor.Tasky.model.exceptions.PasswordsDoNotMatchException;
import com.iamdalibor.Tasky.repository.UserRepository;
import com.iamdalibor.Tasky.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(String email, String password, String repeatPassword, String fName, String lName) {
        if (email==null || email.isEmpty() || password==null || password.isEmpty())
            throw new InvalidUsernameOrPasswordException();
        if (!password.equals(repeatPassword))
            throw new PasswordsDoNotMatchException();
        if (this.userRepository.findBy)
        return null;
    }
}

package com.iamdalibor.Tasky.service;

import com.iamdalibor.Tasky.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {
    UserDetails loadByUsername(String s) throws UsernameNotFoundException;

    public User register(String email, String password, String repeatPassword, String fName, String lName);
}

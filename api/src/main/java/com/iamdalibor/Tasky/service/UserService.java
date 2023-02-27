package com.iamdalibor.Tasky.service;

import com.iamdalibor.Tasky.model.User;

public interface UserService {
    User register(String email, String password, String repeatPassword, String fName, String lName);
}

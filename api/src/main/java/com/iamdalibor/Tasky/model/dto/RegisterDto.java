package com.iamdalibor.Tasky.model.dto;

import lombok.Data;

@Data
public class RegisterDto {
    private String email;
    private String password;
    private String repeatPassword;
    private String fName;
    private String lName;
}

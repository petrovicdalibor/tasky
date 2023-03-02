package com.iamdalibor.Tasky.model.exceptions;

public class EmailTakenException extends RuntimeException{
    public EmailTakenException() {
        super(String.format("This email is already associated with an account."));
    }
}

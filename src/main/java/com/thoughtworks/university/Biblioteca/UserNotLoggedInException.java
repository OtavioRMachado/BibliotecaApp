package com.thoughtworks.university.Biblioteca;

public class UserNotLoggedInException extends Exception {
    public String message = "Error: User not logged in! To log in, please type: LOGIN library-number password";
    public UserNotLoggedInException() {
        super();
    }
}

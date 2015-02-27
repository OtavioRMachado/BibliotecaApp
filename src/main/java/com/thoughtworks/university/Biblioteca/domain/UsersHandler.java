package com.thoughtworks.university.Biblioteca.domain;

import com.thoughtworks.university.Biblioteca.domain.User;

public class UsersHandler {
    public static User log(String libraryNo, String password) {
        if(!libraryNo.matches("\\d{3}-\\d{4}")) {
            return new AnonymousUser();
        }
        User loggedUser = getFromDataIfCorrect(libraryNo, password);
        return loggedUser;
    }

    private static User getFromDataIfCorrect(String libraryNo, String password) {
        if(libraryNo.equals("123-4567") && password.equals("12345")) {
            User loggedUser = new User("Otavio", "omachado@thoughtworks.com", "5381588006", libraryNo);
            return loggedUser;
        }
        return new AnonymousUser();
    }
}

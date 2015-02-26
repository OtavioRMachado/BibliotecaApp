package com.thoughtworks.university.Biblioteca;

public class UsersHandler {
    public static User log(String libraryNo, String password) {
        if(!libraryNo.matches("\\d{3}-\\d{4}")) {
            return null;
        }
        User loggedUser = getFromDataIfCorrect(libraryNo, password);
        return loggedUser;
    }

    private static User getFromDataIfCorrect(String libraryNo, String password) {
        if(libraryNo == "123-4567" && password == "12345") {
            User loggedUser = new User("Otavio", "omachado@thoughtworks.com", "5381588006", libraryNo);
            return loggedUser;
        }
        return null;
    }
}

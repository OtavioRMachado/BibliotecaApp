package com.thoughtworks.university.Biblioteca;

public class UsersHandler {
    public static User log(String libraryNo, String password) {
        if(!libraryNo.matches("\\d{3}-\\d{4}")) {
<<<<<<< HEAD
            return new AnonymousUser();
=======
            return null;
>>>>>>> abfa025a4c8e07a43fbd556d4dfa21ad46e1a990
        }
        User loggedUser = getFromDataIfCorrect(libraryNo, password);
        return loggedUser;
    }

    private static User getFromDataIfCorrect(String libraryNo, String password) {
<<<<<<< HEAD
        if(libraryNo.equals("123-4567") && password.equals("12345")) {
            User loggedUser = new User("Otavio", "omachado@thoughtworks.com", "5381588006", libraryNo);
            return loggedUser;
        }
        return new AnonymousUser();
=======
        if(libraryNo == "123-4567" && password == "12345") {
            User loggedUser = new User("Otavio", "omachado@thoughtworks.com", "5381588006", libraryNo);
            return loggedUser;
        }
        return null;
>>>>>>> abfa025a4c8e07a43fbd556d4dfa21ad46e1a990
    }
}

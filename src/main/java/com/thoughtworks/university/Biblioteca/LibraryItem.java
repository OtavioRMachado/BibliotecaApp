package com.thoughtworks.university.Biblioteca;

public class LibraryItem {
    protected String title;
    protected static int idCounter = 1;
    protected String author;
    protected int uniqueID;
    protected int year;
    protected boolean available;
    protected User whoHas;

    public LibraryItem(String title, String author, int year) {
        this.uniqueID = idCounter;
        idCounter++;
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = true;
        this.whoHas = null;
    }
<<<<<<< HEAD

    public String getClassName() {
        return "item";
    };
=======
>>>>>>> abfa025a4c8e07a43fbd556d4dfa21ad46e1a990
    public boolean isAvailable() {
        return available;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public int getID() {
        return uniqueID;
    }

    public void checkOut(User loggedUser) throws LibraryItemNotAvailableException, UserNotLoggedInException {
        if(!available) {
            throw new LibraryItemNotAvailableException();
        }
<<<<<<< HEAD
        if(loggedUser.getLibraryNo() == "") {
=======
        if(loggedUser == null || loggedUser.getLibraryNo() == null) {
>>>>>>> abfa025a4c8e07a43fbd556d4dfa21ad46e1a990
            throw new UserNotLoggedInException();
        }
        this.available = false;
        this.whoHas = loggedUser;

    }

    public void returnItem(User loggedUser) throws UserNotLoggedInException {
        if(loggedUser == null || loggedUser.getLibraryNo() == null) {
            throw new UserNotLoggedInException();
        }
        this.whoHas = null;
        this.available = true;
    }

    public User WhoHas() {
        return whoHas;
    }
}

package com.thoughtworks.university.Biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    public static void main(String args[]) throws LibraryItemNotAvailableException, UserNotLoggedInException {
        final String WELCOME_MESSAGE = "Welcome to our Virtual Bangalore Biblioteca. To see the available commands, please type OPTIONS";
        String commandMessage;
        List<String> menuItems = new ArrayList<String>();
<<<<<<< HEAD
        List<LibraryItem> availableItems = new ArrayList<LibraryItem>();
        List<LibraryItem> borrowedItems = new ArrayList<LibraryItem>();
=======
        List<LibraryItem> availableBooks = new ArrayList<LibraryItem>();
        List<LibraryItem> borrowedBooks = new ArrayList<LibraryItem>();
>>>>>>> abfa025a4c8e07a43fbd556d4dfa21ad46e1a990
        User loggedUser = new AnonymousUser();

        System.out.println(WELCOME_MESSAGE);

        loadMenu(menuItems);
        loadAvailableItems(availableItems);
        loadBorrowedItems(borrowedItems);

        Command myCommand;
        do {
            myCommand = getCommandFromLine();
<<<<<<< HEAD
            commandMessage = myCommand.loadCommand(availableItems, borrowedItems, menuItems, loggedUser);
=======
            commandMessage = myCommand.loadCommand(availableBooks, borrowedBooks, menuItems, loggedUser);
>>>>>>> abfa025a4c8e07a43fbd556d4dfa21ad46e1a990
            System.out.println(commandMessage);
        } while(!(myCommand instanceof QuitCommand));

    }

<<<<<<< HEAD
    private static void loadBorrowedItems(List<LibraryItem> borrowedItems) {
        return;
    }

    private static void loadAvailableItems(List<LibraryItem> availableItems) {
        Book exampleBook = new Book("Kathy Sierra, Bert Bates", "Head First Java 2nd Edition", 2005);
        Movie exampleMovie = new Movie("Silence of the Lambs", 1991, "Jonathan Demme");
        availableItems.add(exampleBook);
        availableItems.add(exampleMovie);
=======
    private static void loadBorrowedBooks(List<LibraryItem> borrowedBooks) {
        return;
    }

    private static void loadAvailableBooks(List<LibraryItem> availableBooks) {
        Book exampleBook = new Book("Kathy Sierra, Bert Bates", "Head First Java 2nd Edition", 2005);
        availableBooks.add(exampleBook);
>>>>>>> abfa025a4c8e07a43fbd556d4dfa21ad46e1a990
    }

    private static void loadMenu(List<String> menuItems) {
        menuItems.add(ListBooksCommand.getCommandName());
<<<<<<< HEAD
        menuItems.add(ListMoviesCommand.getCommandName());
        menuItems.add(LoginCommand.getCommandName());
=======
>>>>>>> abfa025a4c8e07a43fbd556d4dfa21ad46e1a990
    }

    private static Command getCommandFromLine() {
        String line;
        line = readLine();
        return CommandParser.parseCommand(line);
    }

    protected static String readLine() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        try {
            line = reader.readLine();
        }
        catch(IOException e) {
            e.printStackTrace();
            line = "";
        }
        return line;
    }
}

package com.thoughtworks.university.Biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    public static void main(String args[]) throws LibraryItemNotAvailableException, UserNotLoggedInException {
        final String WELCOME_MESSAGE = "Welcome to our Virtual Bangalore Biblioteca. To see the available commands, please type OPTIONS";
        String line;
        String commandMessage;
        List<String> menuItems = new ArrayList<String>();
        List<LibraryItem> availableBooks = new ArrayList<LibraryItem>();
        List<LibraryItem> borrowedBooks = new ArrayList<LibraryItem>();
        User loggedUser = new User();

        System.out.println(WELCOME_MESSAGE);

        loadMenu(menuItems);
        loadAvailableBooks(availableBooks);
        loadBorrowedBooks(borrowedBooks);

        Command myCommand;
        do {
            myCommand = getCommandFromLine();
            commandMessage = myCommand.loadCommand(availableBooks, borrowedBooks, menuItems, loggedUser);
            System.out.println(commandMessage);
        } while(!(myCommand instanceof QuitCommand));

    }

    private static void loadBorrowedBooks(List<LibraryItem> borrowedBooks) {
        return;
    }

    private static void loadAvailableBooks(List<LibraryItem> availableBooks) {
        Book exampleBook = new Book("Kathy Sierra, Bert Bates", "Head First Java 2nd Edition", 2005);
        availableBooks.add(exampleBook);
    }

    private static void loadMenu(List<String> menuItems) {
        menuItems.add(ListBooksCommand.command);
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

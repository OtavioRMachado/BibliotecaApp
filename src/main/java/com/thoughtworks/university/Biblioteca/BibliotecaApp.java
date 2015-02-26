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
        List<LibraryItem> availableItems = new ArrayList<LibraryItem>();
        List<LibraryItem> borrowedItems = new ArrayList<LibraryItem>();
        User loggedUser = new AnonymousUser();

        System.out.println(WELCOME_MESSAGE);

        loadMenu(menuItems);
        loadAvailableItems(availableItems);
        loadBorrowedItems(borrowedItems);

        Command myCommand;
        do {
            myCommand = getCommandFromLine();
            commandMessage = myCommand.loadCommand(availableItems, borrowedItems, menuItems, loggedUser);
            System.out.println(commandMessage);
        } while(!(myCommand instanceof QuitCommand));

    }

    private static void loadBorrowedItems(List<LibraryItem> borrowedItems) {
        return;
    }

    private static void loadAvailableItems(List<LibraryItem> availableItems) {
        Book exampleBook = new Book("Kathy Sierra, Bert Bates", "Head First Java 2nd Edition", 2005);
        Movie exampleMovie = new Movie("Silence of the Lambs", 1991, "Jonathan Demme");
        availableItems.add(exampleBook);
        availableItems.add(exampleMovie);
    }

    private static void loadMenu(List<String> menuItems) {
        menuItems.add(ListBooksCommand.getCommandName());
        menuItems.add(ListMoviesCommand.getCommandName());
        menuItems.add(LoginCommand.getCommandName());
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

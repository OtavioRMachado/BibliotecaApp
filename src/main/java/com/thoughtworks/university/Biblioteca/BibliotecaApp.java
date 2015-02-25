package com.thoughtworks.university.Biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    public static void main(String args[]) throws BookNotAvailableException {
        final String WELCOME_MESSAGE = "Welcome to our Virtual Bangalore Biblioteca. To see the available commands, please type OPTIONS";
        String line;
        String commandMessage;
        List<String> menuItems = new ArrayList<String>();
        BookHandler availableBooks = new BookHandler();
        BookHandler borrowedBooks = new BookHandler();

        System.out.println(WELCOME_MESSAGE);

        loadMenu(menuItems);
        loadAvailableBooks(availableBooks);
        loadBorrowedBooks(borrowedBooks);

        Command myCommand = getCommandFromLine(availableBooks, borrowedBooks, menuItems);
        while(!(myCommand instanceof QuitCommand)) {
            commandMessage = myCommand.loadCommand(availableBooks, borrowedBooks);
            System.out.println(commandMessage);
            myCommand = getCommandFromLine(availableBooks, borrowedBooks, menuItems);
        }
        commandMessage = myCommand.loadCommand(availableBooks, borrowedBooks);
        System.out.println(commandMessage);
    }

    private static void loadBorrowedBooks(BookHandler borrowedBooks) {
        return;
    }

    private static void loadAvailableBooks(BookHandler availableBooks) {
        Book exampleBook = new Book("Kathy Sierra, Bert Bates", "Head First Java 2nd Edition", 2005);
        availableBooks.addBook(exampleBook);
    }

    private static void loadMenu(List<String> menuItems) {
        menuItems.add(ListBooksCommand.command);
    }

    private static Command getCommandFromLine(BookHandler availableBooks, BookHandler borrowedBooks, List<String> menuItems) {
        String line;
        line = readLine();
        return CommandParser.parseCommand(line, menuItems);
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

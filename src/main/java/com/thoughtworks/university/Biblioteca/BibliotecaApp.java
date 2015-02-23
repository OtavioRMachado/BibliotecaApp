package com.thoughtworks.university.Biblioteca;

import com.sun.tools.javac.comp.Check;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {
    protected static final String WELCOME_MESSAGE = "Welcome to our Virtual Bangalore Biblioteca. To see the available commands, please type OPTIONS";
    protected static String line;
    public static List<String> menuItems = new ArrayList<String>();
    public static BookHandler availableBooks = new BookHandler();
    public static BookHandler borrowedBooks = new BookHandler();

    public static void main(String args[]) throws BookNotAvailableException {
        System.out.println(WELCOME_MESSAGE);

        loadMenu();
        loadAvailableBooks();
        loadBorrowedBooks();

        Command myCommand = getCommandFromLine();
        while(!(myCommand instanceof QuitCommand)) {
            loadCommand(myCommand);
            myCommand = getCommandFromLine();
        }
        myCommand.execute();
    }

    private static void loadBorrowedBooks() {
        return;
    }

    private static void loadAvailableBooks() {
        Book exampleBook = new Book("Kathy Sierra, Bert Bates", "Head First Java 2nd Edition", 2005);
        availableBooks.addBook(exampleBook);
    }

    private static boolean loadCommand(Command myCommand) throws BookNotAvailableException {
        if(myCommand instanceof CheckoutCommand) {
            ((CheckoutCommand) myCommand).setHandlers(availableBooks, borrowedBooks);
        }
        else if(myCommand instanceof ReturnBookCommand) {
            ((ReturnBookCommand) myCommand).setHandlers(availableBooks, borrowedBooks);
        }
        else if(myCommand instanceof ListBooksCommand) {
            ((ListBooksCommand) myCommand).loadBookList(availableBooks);
        }
        myCommand.execute();
        return false;
    }

    private static void loadMenu() {
        menuItems.add(ListBooksCommand.command);
    }

    private static Command getCommandFromLine() {
        line = readLine();
        return CommandParser.parseCommand(line);
    }

    protected static String readLine() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                System.in));
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

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

    public static void main(String args[]) {
        System.out.println(WELCOME_MESSAGE);

        loadMenu();
        Command myCommand = getCommandFromLine();
        while(!(myCommand instanceof QuitCommand)) {
            loadCommand(myCommand);
            myCommand = getCommandFromLine();
        }
        myCommand.execute();
    }

    private static boolean loadCommand(Command myCommand) {
        if(myCommand instanceof CheckoutCommand || myCommand instanceof ReturnBookCommand) {
            // SET BOOK
        }
        else if(myCommand instanceof ListBooksCommand) {
            // Load list of books
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

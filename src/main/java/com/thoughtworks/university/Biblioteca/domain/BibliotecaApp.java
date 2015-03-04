package com.thoughtworks.university.Biblioteca.domain;

import com.thoughtworks.university.Biblioteca.command.*;

import javax.swing.text.html.parser.Parser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * Responsibility: Glue everything together.
 */
public class BibliotecaApp {
    private final static String WELCOME_MESSAGE = "Welcome to our Virtual Bangalore Biblioteca. To see the available commands, please type OPTIONS";

    public static void main(String args[]) throws LibraryItemNotAvailableException, UserNotLoggedInException, IOException {
        String commandMessage;
        List<String> menuItems = new ArrayList<String>();
        List<LibraryItem> availableItems = new ArrayList<LibraryItem>();
        List<LibraryItem> borrowedItems = new ArrayList<LibraryItem>();
        User loggedUser = new AnonymousUser();
        Map<String, ParserCommand> rulesMapping = new HashMap<String, ParserCommand>();
        List<String> lines = new ArrayList<String>();

        System.out.println(WELCOME_MESSAGE);

        loadMenu(menuItems);
        loadAvailableItems(availableItems);
        loadRules(rulesMapping);
        loadBorrowedItems(borrowedItems);

        Command myCommand;
        do {
            myCommand = getCommandFromLine(rulesMapping, lines);
            commandMessage = myCommand.execute(availableItems, borrowedItems, menuItems, loggedUser);
            System.out.println(commandMessage);
        } while(!(myCommand instanceof QuitCommand));

    }

    private static void loadRules(Map<String, ParserCommand> rulesMapping) {
        rulesMapping.put("quit", getQuitParser());
        rulesMapping.put("options", getOptionsParser());
        rulesMapping.put("checkout", getCheckoutParser());
        rulesMapping.put("list books", getListBooksParser());
        rulesMapping.put("list movies",  getListMoviesParser());
        rulesMapping.put("return", getReturnParser());
        rulesMapping.put("profile", getProfileParser());
        rulesMapping.put("login", getLoginParser());
    }

    private static ParserCommand getLoginParser() {
        return new LoginParser();
    }

    private static ParserCommand getProfileParser() {
        return new ProfileParser();
    }

    private static ParserCommand getReturnParser() {
        return new ReturnParser();
    }

    private static ParserCommand getListMoviesParser() {
        return new ListMoviesParser();
    }

    private static ParserCommand getListBooksParser() {
        return new ListBooksParser();
    }

    private static ParserCommand getCheckoutParser() {
        return new CheckoutParser();
    }

    private static ParserCommand getQuitParser() {
        return new QuitParser();
    }

    private static ParserCommand getOptionsParser() {
        return new OptionsParser();
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
        menuItems.add(CheckoutCommand.getCommandName());
        menuItems.add(ReturnItemCommand.getCommandName());
    }

    private static Command getCommandFromLine(Map<String, ParserCommand> rulesMapping, List<String> lines) throws IOException {
        List<String> linesRead = readLine();
        if(!linesRead.isEmpty()) {
            lines.addAll(linesRead);
        }
        CommandParser commandParser = new CommandParser(rulesMapping);
        Command result = commandParser.parse(lines.get(0));
        lines.remove(0);
        return result;
    }

    protected static List<String> readLine() throws IOException {
        BufferedReader myInput = new BufferedReader(new InputStreamReader(System.in));
        List<String> lines = new ArrayList<String>();
        String input = myInput.readLine();
        while(input != null) {
            lines.add(input);
            input = myInput.readLine();
        }
        return lines;
    }
}

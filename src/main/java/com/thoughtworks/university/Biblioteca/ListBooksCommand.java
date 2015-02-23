package com.thoughtworks.university.Biblioteca;

public class ListBooksCommand extends Command {
    public static String command = "LIST BOOKS";
    private static final String commandName = "list books";

    @Override
    public void execute() {

    }


    public static String getCommandName() {
        return commandName;
    }
}

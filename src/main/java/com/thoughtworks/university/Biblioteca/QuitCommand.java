package com.thoughtworks.university.Biblioteca;

public class QuitCommand extends Command {
    public static String commandName = "quit";
    public final String message = "Goodbye!";
    @Override
    protected String execute() {
        return message;
    }

    @Override
    public String loadCommand(BookHandler availableBooks, BookHandler borrowedBooks) throws BookNotAvailableException {
        return execute();
    }

    public static String getCommandName() {
        return commandName;
    }
}

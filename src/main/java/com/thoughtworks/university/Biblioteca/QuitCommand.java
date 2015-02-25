package com.thoughtworks.university.Biblioteca;

import java.util.List;

public class QuitCommand extends Command {
    public static String commandName = "quit";
    public final String message = "Goodbye!";
    @Override
    protected String execute() {
        return message;
    }

    @Override
    public String loadCommand(ItemHandler availableBooks, ItemHandler borrowedBooks, List<String> menuItems, User loggedUser) throws LibraryItemNotAvailableException {
        return execute();
    }

    public static String getCommandName() {
        return commandName;
    }
}

package com.thoughtworks.university.Biblioteca;

import java.util.List;

public class InvalidCommand extends Command {
    protected final String message = "Error: Invalid command! To see commands, type OPTIONS";
    @Override
    public String execute() {
        return message;
    }

    @Override
    public String loadCommand(List<LibraryItem> availableBooks, List<LibraryItem> borrowedBooks, List<String> menuItems, User loggedUser) throws LibraryItemNotAvailableException {
        return execute();
    }
}

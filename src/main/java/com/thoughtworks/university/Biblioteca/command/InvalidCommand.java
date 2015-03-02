package com.thoughtworks.university.Biblioteca.command;

import com.thoughtworks.university.Biblioteca.domain.LibraryItem;
import com.thoughtworks.university.Biblioteca.domain.LibraryItemNotAvailableException;
import com.thoughtworks.university.Biblioteca.domain.User;

import java.util.List;

/*
 * Responsibility: To tell the user when she/he has written an Invalid Command.
 */
public class InvalidCommand extends Command {
    protected final String message = "Error: Invalid command! To see commands, type OPTIONS";

    @Override
    public String execute(List<LibraryItem> availableBooks, List<LibraryItem> borrowedBooks, List<String> menuItems, User loggedUser) throws LibraryItemNotAvailableException {
        return message;
    }
}

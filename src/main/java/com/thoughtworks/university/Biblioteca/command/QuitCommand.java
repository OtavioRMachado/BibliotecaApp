package com.thoughtworks.university.Biblioteca.command;

import com.thoughtworks.university.Biblioteca.domain.LibraryItem;
import com.thoughtworks.university.Biblioteca.domain.LibraryItemNotAvailableException;
import com.thoughtworks.university.Biblioteca.domain.User;

import java.util.List;

public class QuitCommand extends Command {
    public static String commandName = "quit";
    public final String message = "Goodbye!";
    @Override
    public String execute(List<LibraryItem> availableBooks, List<LibraryItem> borrowedBooks, List<String> menuItems, User loggedUser) throws LibraryItemNotAvailableException {
        return message;
    }

    public static String getCommandName() {
        return commandName;
    }
}

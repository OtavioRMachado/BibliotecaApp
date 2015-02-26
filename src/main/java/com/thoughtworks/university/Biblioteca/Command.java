package com.thoughtworks.university.Biblioteca;

import java.util.List;

public abstract class Command {
    protected abstract String execute() throws LibraryItemNotAvailableException, UserNotLoggedInException;
    public abstract String loadCommand(List<LibraryItem> availableBooks, List<LibraryItem> borrowedBooks, List<String> menuItems, User loggedUser) throws LibraryItemNotAvailableException, UserNotLoggedInException;
}

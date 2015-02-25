package com.thoughtworks.university.Biblioteca;

import java.util.List;

public abstract class Command {
    protected abstract String execute() throws LibraryItemNotAvailableException, UserNotLoggedInException;
    public abstract String loadCommand(ItemHandler availableBooks, ItemHandler borrowedBooks, List<String> menuItems, User loggedUser) throws LibraryItemNotAvailableException, UserNotLoggedInException;
}

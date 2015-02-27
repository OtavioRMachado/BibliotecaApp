package com.thoughtworks.university.Biblioteca.command;

import com.thoughtworks.university.Biblioteca.domain.LibraryItem;
import com.thoughtworks.university.Biblioteca.domain.LibraryItemNotAvailableException;
import com.thoughtworks.university.Biblioteca.domain.User;

import java.util.List;

public class OptionsCommand extends Command {
    protected static final String commandName = "options";


    public static String getCommandName() {
        return commandName;
    }

    @Override
    public String execute(List<LibraryItem> availableBooks, List<LibraryItem> borrowedBooks, List<String> menuItems, User loggedUser) throws LibraryItemNotAvailableException {
        StringBuilder menuItemsString = new StringBuilder();
        for (int i = 0; i < menuItems.size(); i++) {
            menuItemsString.append(menuItems.get(i));
            if(i < menuItems.size() - 1) {
                menuItemsString.append(", ");
            }
        }
        return "Menu commands: " + menuItemsString;
    }
}

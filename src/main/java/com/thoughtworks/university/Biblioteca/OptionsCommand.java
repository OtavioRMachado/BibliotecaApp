package com.thoughtworks.university.Biblioteca;

import java.util.List;

public class OptionsCommand extends Command {
    protected static final String commandName = "options";
    private List<String> menuItems;


    public static String getCommandName() {
        return commandName;
    }

    @Override
    public String execute() {
        // Execute OptionsCommand
        StringBuilder menuItemsString = new StringBuilder();
        for (int i = 0; i < menuItems.size(); i++) {
            menuItemsString.append(menuItems.get(i));
            if(i < menuItems.size() - 1) {
                menuItemsString.append(", ");
            }
        }
        return "Menu commands: " + menuItemsString;
    }

    @Override
    public String loadCommand(List<LibraryItem> availableBooks, List<LibraryItem> borrowedBooks, List<String> menuItems, User loggedUser) throws LibraryItemNotAvailableException {
        this.menuItems = menuItems;
        return execute();
    }
}

package com.thoughtworks.university.Biblioteca;

import java.util.List;

public class UserProfileCommand extends Command {
    private static final String commandName = "profile";

    @Override
    protected String execute() throws LibraryItemNotAvailableException, UserNotLoggedInException {
        return null;
    }

    @Override
    public String loadCommand(List<LibraryItem> availableBooks, List<LibraryItem> borrowedBooks, List<String> menuItems, User loggedUser) throws LibraryItemNotAvailableException, UserNotLoggedInException {
        if(loggedUser == null || loggedUser.getLibraryNo() == "") {
            return new UserNotLoggedInException().message;
        }
        return loggedUser.toString();
    }

    public static String getCommandName() {
        return commandName;
    }
}

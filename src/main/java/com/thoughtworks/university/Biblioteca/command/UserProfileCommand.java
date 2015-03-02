package com.thoughtworks.university.Biblioteca.command;

import com.thoughtworks.university.Biblioteca.domain.LibraryItem;
import com.thoughtworks.university.Biblioteca.domain.LibraryItemNotAvailableException;
import com.thoughtworks.university.Biblioteca.domain.User;
import com.thoughtworks.university.Biblioteca.domain.UserNotLoggedInException;

import java.util.List;

/*
 * Responsibility: Its responsibility is to return the user profile with name, e-mail, phone number and library number.
 */
public class UserProfileCommand extends Command {
    private static final String commandName = "profile";

    @Override
    public String execute(List<LibraryItem> availableBooks, List<LibraryItem> borrowedBooks, List<String> menuItems, User loggedUser) throws LibraryItemNotAvailableException, UserNotLoggedInException {
        if(loggedUser == null || loggedUser.getLibraryNo() == "") {
            return new UserNotLoggedInException().message;
        }
        return loggedUser.toString();
    }

    public static String getCommandName() {
        return commandName;
    }
}

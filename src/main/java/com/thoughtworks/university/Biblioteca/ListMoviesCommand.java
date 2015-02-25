package com.thoughtworks.university.Biblioteca;

import java.util.ArrayList;
import java.util.List;

public class ListMoviesCommand extends Command {
    private static final String commandName = "list movies";

    @Override
    protected String execute() throws LibraryItemNotAvailableException, UserNotLoggedInException {
        return "";
    }

    @Override
    public String loadCommand(List<LibraryItem> availableBooks, List<LibraryItem> borrowedBooks, List<String> menuItems, User loggedUser) throws LibraryItemNotAvailableException, UserNotLoggedInException {
        StringBuilder result = new StringBuilder("Our movie list is:\n");
        for(LibraryItem libraryItem : availableBooks) {
            if(libraryItem.getClass() == Movie.class) {
                Movie selectedMovie = (Movie) libraryItem;
                result.append(selectedMovie.toString());
            }
        }
        return result.toString();
    }

    public static String getCommandName() {
        return commandName;
    }
}

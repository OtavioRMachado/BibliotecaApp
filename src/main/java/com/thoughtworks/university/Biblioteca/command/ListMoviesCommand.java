package com.thoughtworks.university.Biblioteca.command;

import com.thoughtworks.university.Biblioteca.domain.*;

import java.util.List;

/*
 * Responsibility: To show the user all movies contained in the list availableItems.
 */
public class ListMoviesCommand extends Command {
    private static final String commandName = "list movies";
    private List<LibraryItem> availableItems;

    @Override
    public String execute(List<LibraryItem> availableItems, List<LibraryItem> borrowedItems, List<String> menuItems, User loggedUser) throws LibraryItemNotAvailableException, UserNotLoggedInException {
        this.availableItems = availableItems;
        return this.toString();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("List of Biblioteca' available Movies:\n");
        for(LibraryItem libraryItem : availableItems) {
            if(libraryItem.getClass() == Movie.class) {
                Movie selectedMovie = (Movie) libraryItem;
                result.append(selectedMovie.toString());
                result.append("\n");
            }
        }
        result.append("To get a movie, type CHECKOUT MOVIE-NUMBER.");
        return result.toString();
    }

    public static String getCommandName() {
        return commandName;
    }
}

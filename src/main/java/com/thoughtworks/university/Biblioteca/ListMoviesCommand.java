package com.thoughtworks.university.Biblioteca;

import java.util.List;

public class ListMoviesCommand extends Command {
    private static final String commandName = "list movies";
    private List<LibraryItem> availableMovies;

    @Override
    protected String execute() throws LibraryItemNotAvailableException, UserNotLoggedInException {
        return "";
    }

    @Override
    public String loadCommand(List<LibraryItem> availableBooks, List<LibraryItem> borrowedBooks, List<String> menuItems, User loggedUser) throws LibraryItemNotAvailableException, UserNotLoggedInException {
        this.availableMovies = availableBooks;
        return this.toString();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("List of Biblioteca' available Movies:\n");
        for(LibraryItem libraryItem : availableMovies) {
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

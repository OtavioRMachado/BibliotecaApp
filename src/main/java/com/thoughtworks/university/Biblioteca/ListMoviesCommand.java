package com.thoughtworks.university.Biblioteca;

import java.util.List;

public class ListMoviesCommand extends Command {
    private static final String commandName = "list movies";
<<<<<<< HEAD
    private List<LibraryItem> availableMovies;
=======
>>>>>>> abfa025a4c8e07a43fbd556d4dfa21ad46e1a990

    @Override
    protected String execute() throws LibraryItemNotAvailableException, UserNotLoggedInException {
        return "";
    }

    @Override
    public String loadCommand(List<LibraryItem> availableBooks, List<LibraryItem> borrowedBooks, List<String> menuItems, User loggedUser) throws LibraryItemNotAvailableException, UserNotLoggedInException {
<<<<<<< HEAD
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
=======
        StringBuilder result = new StringBuilder("Our movie list is:\n");
        for(LibraryItem libraryItem : availableBooks) {
            if(libraryItem.getClass() == Movie.class) {
                Movie selectedMovie = (Movie) libraryItem;
                result.append(selectedMovie.toString());
            }
        }
>>>>>>> abfa025a4c8e07a43fbd556d4dfa21ad46e1a990
        return result.toString();
    }

    public static String getCommandName() {
        return commandName;
    }
}

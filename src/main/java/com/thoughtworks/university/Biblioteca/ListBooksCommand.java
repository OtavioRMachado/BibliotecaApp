package com.thoughtworks.university.Biblioteca;

import java.util.List;

public class ListBooksCommand extends Command {
    public static String command = "LIST BOOKS";
    private static final String commandName = "list books";
    protected List<LibraryItem> bookList;
    private StringBuilder message;
    @Override
    public String execute() {
        Book usedBook;
        message = new StringBuilder();
        message.append("List of Biblioteca's available books:\n");
        for(LibraryItem libraryItem : bookList) {
            usedBook = (Book) libraryItem;
            message.append("(" + usedBook.getID() + ") " + usedBook.getTitle() + " - " + usedBook.getAuthor() + " (" + usedBook.getYear() + ")\n");
        }

        message.append("To get a book, type CHECKOUT BOOK-NUMBER.");
        return message.toString();
    }


    @Override
    public String loadCommand(List<LibraryItem> availableBooks, List<LibraryItem> borrowedBooks, List<String> menuItems, User loggedUser) throws LibraryItemNotAvailableException {
        loadBookList(availableBooks);
        return execute();
    }

    public void loadBookList(List<LibraryItem> bookList) {
        this.bookList = bookList;
    }
    public static String getCommandName() {
        return commandName;
    }
}

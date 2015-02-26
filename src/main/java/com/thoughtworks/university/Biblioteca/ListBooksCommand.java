package com.thoughtworks.university.Biblioteca;

import java.util.List;

public class ListBooksCommand extends Command {
    private static final String commandName = "list books";
    protected List<LibraryItem> bookList;
    private StringBuilder message;
    @Override
    public String execute() {
        return this.toString();
    }


    @Override
    public String loadCommand(List<LibraryItem> availableBooks, List<LibraryItem> borrowedBooks, List<String> menuItems, User loggedUser) throws LibraryItemNotAvailableException {
        loadBookList(availableBooks);
        return execute();
    }

    @Override
    public String toString() {
        Book usedBook;
        message = new StringBuilder();
        message.append("List of Biblioteca's available books:\n");
        for(LibraryItem libraryItem : bookList) {
<<<<<<< HEAD
            if(libraryItem.getClass() == Book.class) {
                usedBook = (Book) libraryItem;
                message.append(usedBook.toString());
                message.append("\n");
            }
=======
            usedBook = (Book) libraryItem;
            message.append(usedBook.toString());
>>>>>>> abfa025a4c8e07a43fbd556d4dfa21ad46e1a990
        }
        message.append("To get a book, type CHECKOUT BOOK-NUMBER.");
        return message.toString();
    }

    public void loadBookList(List<LibraryItem> bookList) {
        this.bookList = bookList;
    }
    public static String getCommandName() {
        return commandName;
    }
}

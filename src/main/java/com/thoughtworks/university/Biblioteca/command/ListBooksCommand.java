package com.thoughtworks.university.Biblioteca.command;

import com.thoughtworks.university.Biblioteca.domain.LibraryItem;
import com.thoughtworks.university.Biblioteca.domain.LibraryItemNotAvailableException;
import com.thoughtworks.university.Biblioteca.domain.User;
import com.thoughtworks.university.Biblioteca.domain.Book;

import java.util.List;

/*
 * Responsibility: To show the user all books contained in the list availableItems.
 */
public class ListBooksCommand extends Command {
    private static final String commandName = "list books";
    protected List<LibraryItem> itemsList;
    private StringBuilder message;
    @Override
    public String execute(List<LibraryItem> availableItems, List<LibraryItem> borrowedItems, List<String> menuItems, User loggedUser) throws LibraryItemNotAvailableException {
        this.itemsList = availableItems;
        return this.toString();
    }

    @Override
    public String toString() {
        Book usedBook;
        message = new StringBuilder();
        message.append("List of Biblioteca's available books:\n");
        for(LibraryItem libraryItem : itemsList) {
            if(libraryItem.getClass() == Book.class) {
                usedBook = (Book) libraryItem;
                message.append(usedBook.toString());
                message.append("\n");
            }
        }
        message.append("To get a book, type CHECKOUT BOOK-NUMBER.");
        return message.toString();
    }

    public static String getCommandName() {
        return commandName;
    }
}

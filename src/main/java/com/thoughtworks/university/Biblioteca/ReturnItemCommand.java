package com.thoughtworks.university.Biblioteca;

import java.util.List;

public class ReturnItemCommand extends Command {
    public static String commandName = "return";
    private ItemHandler availableBooks;
    private ItemHandler borrowedBooks;
    private Book desiredBook;
    private int bookID;
    private User loggedUser;
    private final String successMessage = "Thank you for returning the book.";
    private final String failureMessage = "That book is not available.";

    @Override
    public String execute() {
        try {
            desiredBook = (Book) borrowedBooks.getById(bookID);
            desiredBook.returnItem(loggedUser);
            borrowedBooks.removeItem(desiredBook);
            availableBooks.addItem(desiredBook);
        }
        catch(NullPointerException nullPointerExc) {
            return failureMessage;
        } catch (UserNotLoggedInException e) {
            return e.message;
        }
        return successMessage;
    }

    @Override
    public String loadCommand(ItemHandler availableBooks, ItemHandler borrowedBooks, List<String> menuItems, User loggedUser) throws LibraryItemNotAvailableException {
        this.availableBooks = availableBooks;
        this.borrowedBooks = borrowedBooks;
        this.loggedUser = loggedUser;
        return execute();
    }

    public ReturnItemCommand(int value) {
        bookID = value;
    }

    public static String getCommandName() {
        return commandName;
    }
}

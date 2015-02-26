package com.thoughtworks.university.Biblioteca;

import java.util.List;

public class ReturnItemCommand extends Command {
    public static String commandName = "return";
    private List<LibraryItem> availableBooks;
    private List<LibraryItem> borrowedBooks;
    private Book desiredBook;
    private int bookID;
    private User loggedUser;
    private final String successMessage = "Thank you for returning the book.";
    private final String failureMessage = "That book is not available.";

    @Override
    public String execute() {
        try {
            desiredBook = getBookById(bookID);
            desiredBook.returnItem(loggedUser);
            borrowedBooks.remove(desiredBook);
            availableBooks.add(desiredBook);
        }
        catch(NullPointerException nullPointerExc) {
            return failureMessage;
        } catch (UserNotLoggedInException e) {
            return e.message;
        }
        return successMessage;
    }

    private Book getBookById(int desiredID) {
        for(LibraryItem libraryItem : borrowedBooks) {
            if(libraryItem.getID() == desiredID) {
                return (Book) libraryItem;
            }
        }

        return null;
    }

    @Override
    public String loadCommand(List<LibraryItem> availableBooks, List<LibraryItem> borrowedBooks, List<String> menuItems, User loggedUser) throws LibraryItemNotAvailableException {
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

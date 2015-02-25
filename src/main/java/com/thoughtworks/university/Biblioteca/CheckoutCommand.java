package com.thoughtworks.university.Biblioteca;

import java.util.List;

public class CheckoutCommand extends Command {
    private static final String commandName = "checkout";
    private List<LibraryItem> availableBooks;
    private List<LibraryItem> borrowedBooks;
    private Book desiredBook;
    private User loggedUser;
    private int bookID;
    private static final String successMessage = "Thank you! Enjoy the book.";
    public CheckoutCommand(int bookID) {
        this.bookID = bookID;
    }

    @Override
    protected String execute() throws LibraryItemNotAvailableException, UserNotLoggedInException {
        try {
            desiredBook = getBookById(bookID);
            desiredBook.checkOut(loggedUser);
            availableBooks.remove(desiredBook);
            borrowedBooks.add(desiredBook);
        }
        catch(LibraryItemNotAvailableException exception) {
            throw new LibraryItemNotAvailableException();
        }
        catch(NullPointerException nullPointerExc) {
            return new InvalidCommand().execute();
        } catch (UserNotLoggedInException e) {
            return e.message;
        }
        return successMessage;
    }

    @Override
    public String loadCommand(List<LibraryItem> availableBooks, List<LibraryItem> borrowedBooks, List<String> menuItems, User loggedUser) throws LibraryItemNotAvailableException, UserNotLoggedInException {
        this.availableBooks = availableBooks;
        this.borrowedBooks = borrowedBooks;
        this.loggedUser = loggedUser;
        String message = execute();
        return message;
    }

    private Book getBookById(int desiredID) {
        for(LibraryItem libraryItem : availableBooks) {
            if(libraryItem.getID() == desiredID) {
                return (Book) libraryItem;
            }
        }

        return null;
    }
    public static String getCommandName() {
        return commandName;
    }
}

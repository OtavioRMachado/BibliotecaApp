package com.thoughtworks.university.Biblioteca;

import java.util.List;

public class CheckoutCommand extends Command {
    private static final String commandName = "checkout";
    private ItemHandler availableBooks;
    private ItemHandler borrowedBooks;
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
            desiredBook = (Book) availableBooks.getById(bookID);
            desiredBook.checkOut(loggedUser);
            availableBooks.removeItem(desiredBook);
            borrowedBooks.addItem(desiredBook);
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
    public String loadCommand(ItemHandler availableBooks, ItemHandler borrowedBooks, List<String> menuItems, User loggedUser) throws LibraryItemNotAvailableException, UserNotLoggedInException {
        this.availableBooks = availableBooks;
        this.borrowedBooks = borrowedBooks;
        this.loggedUser = loggedUser;
        String message = execute();
        return message;
    }

    public static String getCommandName() {
        return commandName;
    }
}

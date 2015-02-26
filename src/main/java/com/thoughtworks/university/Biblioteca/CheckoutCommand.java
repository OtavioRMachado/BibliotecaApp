package com.thoughtworks.university.Biblioteca;

import java.util.List;

public class CheckoutCommand extends Command {
    private static final String commandName = "checkout";
<<<<<<< HEAD
    private List<LibraryItem> availableItems;
    private List<LibraryItem> borrowedItems;
    private LibraryItem desiredItem;
    private User loggedUser;
    private int itemID;
    private static final String successMessage = "Thank you! Enjoy the %s";
    public CheckoutCommand(int itemID) {
        this.itemID = itemID;
=======
    private List<LibraryItem> availableBooks;
    private List<LibraryItem> borrowedBooks;
    private Book desiredBook;
    private User loggedUser;
    private int bookID;
    private static final String successMessage = "Thank you! Enjoy the book.";
    public CheckoutCommand(int bookID) {
        this.bookID = bookID;
>>>>>>> abfa025a4c8e07a43fbd556d4dfa21ad46e1a990
    }

    @Override
    protected String execute() throws LibraryItemNotAvailableException, UserNotLoggedInException {
        try {
<<<<<<< HEAD
            desiredItem = getItemById(itemID);
            desiredItem.checkOut(loggedUser);
            availableItems.remove(desiredItem);
            borrowedItems.add(desiredItem);
=======
            desiredBook = getBookById(bookID);
            desiredBook.checkOut(loggedUser);
            availableBooks.remove(desiredBook);
            borrowedBooks.add(desiredBook);
>>>>>>> abfa025a4c8e07a43fbd556d4dfa21ad46e1a990
        }
        catch(LibraryItemNotAvailableException exception) {
            throw new LibraryItemNotAvailableException();
        }
        catch(NullPointerException nullPointerExc) {
            return new InvalidCommand().execute();
        } catch (UserNotLoggedInException e) {
            return e.message;
        }
        return String.format(successMessage, desiredItem.getClassName());
    }

    @Override
    public String loadCommand(List<LibraryItem> availableBooks, List<LibraryItem> borrowedBooks, List<String> menuItems, User loggedUser) throws LibraryItemNotAvailableException, UserNotLoggedInException {
<<<<<<< HEAD
        this.availableItems = availableBooks;
        this.borrowedItems = borrowedBooks;
=======
        this.availableBooks = availableBooks;
        this.borrowedBooks = borrowedBooks;
>>>>>>> abfa025a4c8e07a43fbd556d4dfa21ad46e1a990
        this.loggedUser = loggedUser;
        String message = execute();
        return message;
    }

<<<<<<< HEAD
    private LibraryItem getItemById(int desiredID) {
        for(LibraryItem libraryItem : availableItems) {
            if(libraryItem.getID() == desiredID) {
                return libraryItem;
=======
    private Book getBookById(int desiredID) {
        for(LibraryItem libraryItem : availableBooks) {
            if(libraryItem.getID() == desiredID) {
                return (Book) libraryItem;
>>>>>>> abfa025a4c8e07a43fbd556d4dfa21ad46e1a990
            }
        }

        return null;
    }
    public static String getCommandName() {
        return commandName;
    }
}

package com.thoughtworks.university.Biblioteca;

import java.util.List;

public class ReturnItemCommand extends Command {
    public static String commandName = "return";
<<<<<<< HEAD
    private List<LibraryItem> availableItems;
    private List<LibraryItem> borrowedItems;
    private LibraryItem desiredItem;
    private int itemID;
    private User loggedUser;
    private final String successMessage = "Thank you for returning the %s";
    private final String failureMessage = "That item is not available.";
=======
    private List<LibraryItem> availableBooks;
    private List<LibraryItem> borrowedBooks;
    private Book desiredBook;
    private int bookID;
    private User loggedUser;
    private final String successMessage = "Thank you for returning the book.";
    private final String failureMessage = "That book is not available.";
>>>>>>> abfa025a4c8e07a43fbd556d4dfa21ad46e1a990

    @Override
    public String execute() {
        try {
<<<<<<< HEAD
            desiredItem = getItemByID(itemID);
            desiredItem.returnItem(loggedUser);
            borrowedItems.remove(desiredItem);
            availableItems.add(desiredItem);
        }
        catch(NullPointerException nullPointerExc) {
            return String.format(failureMessage);
        } catch (UserNotLoggedInException e) {
            return e.message;
        }
        return String.format(successMessage, desiredItem.getClassName());
    }

    private LibraryItem getItemByID(int desiredID) {
        for(LibraryItem libraryItem : borrowedItems) {
            if(libraryItem.getID() == desiredID) {
                return libraryItem;
=======
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
>>>>>>> abfa025a4c8e07a43fbd556d4dfa21ad46e1a990
            }
        }

        return null;
    }

    @Override
    public String loadCommand(List<LibraryItem> availableBooks, List<LibraryItem> borrowedBooks, List<String> menuItems, User loggedUser) throws LibraryItemNotAvailableException {
<<<<<<< HEAD
        this.availableItems = availableBooks;
        this.borrowedItems = borrowedBooks;
=======
        this.availableBooks = availableBooks;
        this.borrowedBooks = borrowedBooks;
>>>>>>> abfa025a4c8e07a43fbd556d4dfa21ad46e1a990
        this.loggedUser = loggedUser;
        return execute();
    }

    public ReturnItemCommand(int value) {
<<<<<<< HEAD
        itemID = value;
=======
        bookID = value;
>>>>>>> abfa025a4c8e07a43fbd556d4dfa21ad46e1a990
    }

    public static String getCommandName() {
        return commandName;
    }
}

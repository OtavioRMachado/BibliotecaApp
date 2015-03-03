package com.thoughtworks.university.Biblioteca.command;

import com.thoughtworks.university.Biblioteca.domain.LibraryItem;
import com.thoughtworks.university.Biblioteca.domain.LibraryItemNotAvailableException;
import com.thoughtworks.university.Biblioteca.domain.User;
import com.thoughtworks.university.Biblioteca.domain.UserNotLoggedInException;

import java.util.List;

/*
 * Responsibility: Checkout books.
 * It gets the available books, the ID of the Book I want
 * and marks it as not available.
 */
public class CheckoutCommand extends Command {
    private static final String commandName = "checkout";
    private LibraryItem desiredItem;
    private int itemID;
    private static final String successMessage = "Thank you! Enjoy the %s";
    private static final String failureMessage = "That item is not available.";

    public CheckoutCommand(int itemID) {
        this.itemID = itemID;
    }

    @Override
    public String execute(List<LibraryItem> availableItems, List<LibraryItem> borrowedItems, List<String> menuItems, User loggedUser) throws LibraryItemNotAvailableException, UserNotLoggedInException {
        try {
            desiredItem = getItemById(itemID, availableItems);
            desiredItem.checkOut(loggedUser);
            availableItems.remove(desiredItem);
            borrowedItems.add(desiredItem);
        } catch(NullPointerException nullPointerExc) {
            return failureMessage;
        } catch (UserNotLoggedInException e) {
            return e.message;
        }

        return String.format(successMessage, desiredItem.getClass().getSimpleName());
    }

    private LibraryItem getItemById(int desiredID, List<LibraryItem> availableItems) {
        for(LibraryItem libraryItem : availableItems) {
            if(libraryItem.getID() == desiredID) {
                return libraryItem;
            }
        }

        return null;
    }
    public static String getCommandName() {
        return commandName;
    }
}

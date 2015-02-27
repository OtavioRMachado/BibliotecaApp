package com.thoughtworks.university.Biblioteca.command;

import com.thoughtworks.university.Biblioteca.domain.LibraryItem;
import com.thoughtworks.university.Biblioteca.domain.LibraryItemNotAvailableException;
import com.thoughtworks.university.Biblioteca.domain.User;
import com.thoughtworks.university.Biblioteca.domain.UserNotLoggedInException;

import java.util.List;

public class ReturnItemCommand extends Command {
    public static String commandName = "return";
    private final String successMessage = "Thank you for returning \"%s\"";
    private final String failureMessage = "That item is not available.";
    private int itemID;

    public ReturnItemCommand(int value) {
        itemID = value;
    }

    @Override
    public String execute(List<LibraryItem> availableItems, List<LibraryItem> borrowedItems, List<String> menuItems, User loggedUser) throws LibraryItemNotAvailableException {
        LibraryItem desiredItem;
        try {
            desiredItem = getItemByID(itemID, borrowedItems);
            desiredItem.returnItem(loggedUser);
            borrowedItems.remove(desiredItem);
            availableItems.add(desiredItem);
        }
        catch(NullPointerException nullPointerExc) {
            return String.format(failureMessage);
        } catch (UserNotLoggedInException e) {
            return e.message;
        }
        return String.format(successMessage, desiredItem.getTitle());
    }

    private LibraryItem getItemByID(int desiredID, List<LibraryItem> borrowedItems) {
        for(LibraryItem libraryItem : borrowedItems) {
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

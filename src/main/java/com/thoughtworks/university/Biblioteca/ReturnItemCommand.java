package com.thoughtworks.university.Biblioteca;

import java.util.List;

public class ReturnItemCommand extends Command {
    public static String commandName = "return";
    private List<LibraryItem> availableItems;
    private List<LibraryItem> borrowedItems;
    private LibraryItem desiredItem;
    private int itemID;
    private User loggedUser;
    private final String successMessage = "Thank you for returning \"%s\"";
    private final String failureMessage = "That item is not available.";

    @Override
    public String execute() {
        try {
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
        return String.format(successMessage, desiredItem.getTitle());
    }

    private LibraryItem getItemByID(int desiredID) {
        for(LibraryItem libraryItem : borrowedItems) {
            if(libraryItem.getID() == desiredID) {
                return libraryItem;
            }
        }

        return null;
    }

    @Override
    public String loadCommand(List<LibraryItem> availableBooks, List<LibraryItem> borrowedBooks, List<String> menuItems, User loggedUser) throws LibraryItemNotAvailableException {
        this.availableItems = availableBooks;
        this.borrowedItems = borrowedBooks;
        this.loggedUser = loggedUser;
        return execute();
    }

    public ReturnItemCommand(int value) {
        itemID = value;
    }

    public static String getCommandName() {
        return commandName;
    }
}

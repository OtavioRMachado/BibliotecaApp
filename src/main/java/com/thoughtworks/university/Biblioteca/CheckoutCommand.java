package com.thoughtworks.university.Biblioteca;

import java.util.List;

public class CheckoutCommand extends Command {
    private static final String commandName = "checkout";
    private List<LibraryItem> availableItems;
    private List<LibraryItem> borrowedItems;
    private LibraryItem desiredItem;
    private User loggedUser;
    private int itemID;
    private static final String successMessage = "Thank you! Enjoy the %s";
    public CheckoutCommand(int itemID) {
        this.itemID = itemID;
    }

    @Override
    protected String execute() throws LibraryItemNotAvailableException, UserNotLoggedInException {
        try {
            desiredItem = getItemById(itemID);
            desiredItem.checkOut(loggedUser);
            availableItems.remove(desiredItem);
            borrowedItems.add(desiredItem);
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
        this.availableItems = availableBooks;
        this.borrowedItems = borrowedBooks;
        this.loggedUser = loggedUser;
        String message = execute();
        return message;
    }

    private LibraryItem getItemById(int desiredID) {
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

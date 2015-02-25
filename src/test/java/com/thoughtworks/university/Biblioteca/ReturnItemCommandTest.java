package com.thoughtworks.university.Biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ReturnItemCommandTest {
    @Test
    public void shouldReturnBook() throws LibraryItemNotAvailableException, NullPointerException, UserNotLoggedInException {
        Book myBook = new Book("JKRowling", "HP", 1991);
        ItemHandler availableBooks = new ItemHandler();
        ItemHandler notAvailableBooks = new ItemHandler();
        User user = new User("Otavio", "omachado@thoughtworks.com", "05381588006");

        notAvailableBooks.addItem(myBook);
        myBook.checkOut(user);
        ReturnItemCommand returnItemCommand = new ReturnItemCommand(myBook.getID());
        returnItemCommand.loadCommand(availableBooks, notAvailableBooks, new ArrayList<String>(), user);
        assertTrue(availableBooks.getById(myBook.getID()) != null);
        assertFalse(notAvailableBooks.getById(myBook.getID()) != null);
        assertTrue(myBook.isAvailable());
    }
    @Test
    public void shouldNotReturnBookBecauseItIsNotBorrowed() throws LibraryItemNotAvailableException {
        User user = new User("Otavio", "omachado@thoughtworks.com", "05381588006");
        ItemHandler availableBooks = new ItemHandler();
        ItemHandler notAvailableBooks = new ItemHandler();
        ReturnItemCommand returnItemCommand = new ReturnItemCommand(99);
        assertEquals("That book is not available.", returnItemCommand.loadCommand(availableBooks, notAvailableBooks, new ArrayList<String>(), user));
    }
}

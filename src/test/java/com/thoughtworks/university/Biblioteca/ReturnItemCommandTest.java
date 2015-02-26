package com.thoughtworks.university.Biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ReturnItemCommandTest {
    @Test
    public void shouldReturnBook() throws LibraryItemNotAvailableException, NullPointerException, UserNotLoggedInException {
        Book myBook = new Book("JKRowling", "HP", 1991);
        List<LibraryItem> availableBooks = new ArrayList<LibraryItem>();
        List<LibraryItem> notAvailableBooks = new ArrayList<LibraryItem>();
        User user = new User("Otavio", "omachado@thoughtworks.com", "05381588006", "12345");

        notAvailableBooks.add(myBook);
        myBook.checkOut(user);
        ReturnItemCommand returnItemCommand = new ReturnItemCommand(myBook.getID());
        returnItemCommand.loadCommand(availableBooks, notAvailableBooks, new ArrayList<String>(), user);
        assertTrue(availableBooks.contains(myBook));
        assertFalse(notAvailableBooks.contains(myBook));
        assertTrue(myBook.isAvailable());
    }
    @Test
    public void shouldNotReturnBookBecauseItIsNotBorrowed() throws LibraryItemNotAvailableException {
        User user = new User("Otavio", "omachado@thoughtworks.com", "05381588006", "12345");
        List<LibraryItem> availableBooks = new ArrayList<LibraryItem>();
        List<LibraryItem> notAvailableBooks = new ArrayList<LibraryItem>();
        ReturnItemCommand returnItemCommand = new ReturnItemCommand(99);
        assertEquals("That item is not available.", returnItemCommand.loadCommand(availableBooks, notAvailableBooks, new ArrayList<String>(), user));
    }
}

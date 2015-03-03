package com.thoughtworks.university.Biblioteca.command;

import com.thoughtworks.university.Biblioteca.domain.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ReturnItemCommandTest {
    List<LibraryItem> availableBooks;
    List<LibraryItem> notAvailableBooks;
    User user;
    @Before
    public void setUp() {
        availableBooks = new ArrayList<LibraryItem>();
        notAvailableBooks = new ArrayList<LibraryItem>();
        user = new User("Otavio", "omachado@thoughtworks.com", "05381588006", "12345");
    }
    @Test
    public void shouldReturnBook() throws LibraryItemNotAvailableException, NullPointerException, UserNotLoggedInException {
        Book myBook = new Book("JKRowling", "HP", 1991);
        ReturnItemCommand returnItemCommand = new ReturnItemCommand(myBook.getID());

        notAvailableBooks.add(myBook);
        myBook.checkOut(user);
        returnItemCommand.execute(availableBooks, notAvailableBooks, new ArrayList<String>(), user);

        assertTrue(availableBooks.contains(myBook));
        assertFalse(notAvailableBooks.contains(myBook));
        assertTrue(myBook.isAvailable());
    }
    @Test
    public void shouldNotReturnBookBecauseItIsNotBorrowed() throws LibraryItemNotAvailableException {
        ReturnItemCommand returnItemCommand = new ReturnItemCommand(99);

        assertEquals("That item is not available.", returnItemCommand.execute(availableBooks, notAvailableBooks, new ArrayList<String>(), user));
    }
}

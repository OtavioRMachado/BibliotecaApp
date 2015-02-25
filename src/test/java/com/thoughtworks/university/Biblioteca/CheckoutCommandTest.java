package com.thoughtworks.university.Biblioteca;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class CheckoutCommandTest {
    @Test
    public void shouldCheckoutBook() throws LibraryItemNotAvailableException, UserNotLoggedInException {
        Book myBook = new Book("JKRowling", "HP", 1991);
        ItemHandler availableBooks = new ItemHandler();
        ItemHandler notAvailableBooks = new ItemHandler();
        availableBooks.addItem(myBook);
        CheckoutCommand checkoutCommand = new CheckoutCommand(myBook.getID());
        User user = new User("Otavio", "omachado@thoughtworks.com", "05381588006");
        checkoutCommand.loadCommand(availableBooks, notAvailableBooks, new ArrayList<String>(), user);
        assertFalse(availableBooks.getById(myBook.getID()) != null);
        assertTrue(notAvailableBooks.getById(myBook.getID()) != null);
    }

    @Test(expected = LibraryItemNotAvailableException.class)
    public void shouldNotCheckoutBookBecauseItIsNotAvailable() throws LibraryItemNotAvailableException, UserNotLoggedInException {
        Book myBook = new Book("JKRowling", "HP", 1991);
        User loggedUser = new User("Otavio", "omachado@thoughtworks.com", "05381588006");
        myBook.checkOut(loggedUser);
        ItemHandler availableBooks = new ItemHandler();
        ItemHandler notAvailableBooks = new ItemHandler();
        availableBooks.addItem(myBook);
        CheckoutCommand checkoutCommand = new CheckoutCommand(myBook.getID());
        checkoutCommand.loadCommand(availableBooks, notAvailableBooks, new ArrayList<String>(), loggedUser);
    }
    @Test
    public void shouldNotCheckoutBookBecauseItDoesNotExist() throws LibraryItemNotAvailableException, UserNotLoggedInException {
        ExpectedException expectedException = ExpectedException.none();
        User loggedUser = new User("Otavio", "omachado@thoughtworks.com", "05381588006");
        ItemHandler availableBooks = new ItemHandler();
        ItemHandler notAvailableBooks = new ItemHandler();
        expectedException.expect(NullPointerException.class);
        CheckoutCommand checkoutCommand = new CheckoutCommand(99);
        assertEquals(new InvalidCommand().execute(), checkoutCommand.loadCommand(availableBooks, notAvailableBooks, new ArrayList<String>(), loggedUser));
    }
}

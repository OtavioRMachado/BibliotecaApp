package com.thoughtworks.university.Biblioteca.command;

import com.thoughtworks.university.Biblioteca.domain.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class CheckoutCommandTest {
    List<LibraryItem> availableBooks;
    List<LibraryItem> notAvailableBooks;
    Book harryPotter;
    User user;
    ArrayList<String> menuItems;

    @Before
    public void setUp() {
        availableBooks = new ArrayList<LibraryItem>();
        notAvailableBooks = new ArrayList<LibraryItem>();
        harryPotter = new Book("JKRowling", "HP", 1991);
        menuItems = new ArrayList<String>();
        user = new User("Otavio", "omachado@thoughtworks.com", "05381588006", "12345");
    }
    @Test
    public void shouldCheckoutBook() throws LibraryItemNotAvailableException, UserNotLoggedInException {
        CheckoutCommand checkoutCommand = new CheckoutCommand(harryPotter.getID());

        availableBooks.add(harryPotter);
        checkoutCommand.execute(availableBooks, notAvailableBooks, menuItems, user);

        assertFalse(availableBooks.contains(harryPotter));
        assertTrue(notAvailableBooks.contains(harryPotter));
    }

    @Test(expected = LibraryItemNotAvailableException.class)
    public void shouldNotCheckoutBookBecauseItIsNotAvailable() throws LibraryItemNotAvailableException, UserNotLoggedInException {
        CheckoutCommand checkoutCommand = new CheckoutCommand(harryPotter.getID());

        harryPotter.checkOut(user);
        availableBooks.add(harryPotter);

        checkoutCommand.execute(availableBooks, notAvailableBooks, new ArrayList<String>(), user);
    }
    @Test
    public void shouldNotCheckoutBookBecauseItDoesNotExist() throws LibraryItemNotAvailableException, UserNotLoggedInException {
        CheckoutCommand checkoutCommand = new CheckoutCommand(99);

        assertEquals(new InvalidCommand().execute(availableBooks, notAvailableBooks, new ArrayList<String>(), user),
                checkoutCommand.execute(availableBooks, notAvailableBooks, new ArrayList<String>(), user));
    }
}

package com.thoughtworks.university.Biblioteca.command;

import com.thoughtworks.university.Biblioteca.domain.*;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class CheckoutCommandTest {
    @Test
    public void shouldCheckoutBook() throws LibraryItemNotAvailableException, UserNotLoggedInException {
        List<LibraryItem> availableBooks = new ArrayList<LibraryItem>();
        List<LibraryItem> notAvailableBooks = new ArrayList<LibraryItem>();

        Book harryPotter = new Book("JKRowling", "HP", 1991);
        availableBooks.add(harryPotter);

        CheckoutCommand checkoutCommand = new CheckoutCommand(harryPotter.getID());
        User user = new User("Otavio", "omachado@thoughtworks.com", "05381588006", "12345");

        ArrayList<String> menuItems = new ArrayList<String>();
        checkoutCommand.execute(availableBooks, notAvailableBooks, menuItems, user);

        assertFalse(availableBooks.contains(harryPotter));
        assertTrue(notAvailableBooks.contains(harryPotter));
    }

    @Test(expected = LibraryItemNotAvailableException.class)
    public void shouldNotCheckoutBookBecauseItIsNotAvailable() throws LibraryItemNotAvailableException, UserNotLoggedInException {
        Book myBook = new Book("JKRowling", "HP", 1991);
        User loggedUser = new User("Otavio", "omachado@thoughtworks.com", "05381588006", "12345");
        myBook.checkOut(loggedUser);
        List<LibraryItem> availableBooks = new ArrayList<LibraryItem>();
        List<LibraryItem> notAvailableBooks = new ArrayList<LibraryItem>();
        availableBooks.add(myBook);
        CheckoutCommand checkoutCommand = new CheckoutCommand(myBook.getID());
        checkoutCommand.execute(availableBooks, notAvailableBooks, new ArrayList<String>(), loggedUser);
    }
    @Test
    public void shouldNotCheckoutBookBecauseItDoesNotExist() throws LibraryItemNotAvailableException, UserNotLoggedInException {
        ExpectedException expectedException = ExpectedException.none();
        User loggedUser = new User("Otavio", "omachado@thoughtworks.com", "05381588006", "12345");
        List<LibraryItem> availableBooks = new ArrayList<LibraryItem>();
        List<LibraryItem> notAvailableBooks = new ArrayList<LibraryItem>();
        expectedException.expect(NullPointerException.class);
        CheckoutCommand checkoutCommand = new CheckoutCommand(99);
        assertEquals(new InvalidCommand().execute(availableBooks, notAvailableBooks, new ArrayList<String>(), loggedUser),
                checkoutCommand.execute(availableBooks, notAvailableBooks, new ArrayList<String>(), loggedUser));
    }
}

package com.thoughtworks.university.Biblioteca;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class CheckoutCommandTest {
    @Test
    public void shouldCheckoutBook() throws BookNotAvailableException {
        Book myBook = new Book("JKRowling", "HP", 1991);
        BookHandler availableBooks = new BookHandler();
        BookHandler notAvailableBooks = new BookHandler();
        availableBooks.addBook(myBook);
        CheckoutCommand checkoutCommand = new CheckoutCommand(myBook.getID());
        checkoutCommand.loadCommand(availableBooks, notAvailableBooks);
        assertFalse(availableBooks.getById(myBook.getID()) != null);
        assertTrue(notAvailableBooks.getById(myBook.getID()) != null);
    }

    @Test(expected = BookNotAvailableException.class)
    public void shouldNotCheckoutBookBecauseItIsNotAvailable() throws BookNotAvailableException {
        Book myBook = new Book("JKRowling", "HP", 1991);
        myBook.checkOut();
        BookHandler availableBooks = new BookHandler();
        BookHandler notAvailableBooks = new BookHandler();
        availableBooks.addBook(myBook);
        CheckoutCommand checkoutCommand = new CheckoutCommand(myBook.getID());
        checkoutCommand.loadCommand(availableBooks, notAvailableBooks);
    }
    @Test(expected = NullPointerException.class)
    public void shouldNotCheckoutBookBecauseItDoesNotExist() throws BookNotAvailableException {
        ExpectedException expectedException = ExpectedException.none();
        BookHandler availableBooks = new BookHandler();
        BookHandler notAvailableBooks = new BookHandler();
        expectedException.expect(NullPointerException.class);
        CheckoutCommand checkoutCommand = new CheckoutCommand(99);
        checkoutCommand.loadCommand(availableBooks, notAvailableBooks);
        checkoutCommand.execute();
    }
}

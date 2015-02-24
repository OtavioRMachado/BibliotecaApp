package com.thoughtworks.university.Biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ReturnBookCommandTest {
    @Test
    public void shouldReturnBook() throws BookNotAvailableException, NullPointerException {
        Book myBook = new Book("JKRowling", "HP", 1991);
        BookHandler availableBooks = new BookHandler();
        BookHandler notAvailableBooks = new BookHandler();
        notAvailableBooks.addBook(myBook);
        myBook.checkOut();
        ReturnBookCommand returnBookCommand = new ReturnBookCommand(myBook.getID());
        returnBookCommand.loadCommand(availableBooks, notAvailableBooks);
        assertTrue(availableBooks.getById(myBook.getID()) != null);
        assertFalse(notAvailableBooks.getById(myBook.getID()) != null);
        assertTrue(myBook.isAvailable());
    }
    @Test
    public void shouldNotReturnBookBecauseItIsNotBorrowed() throws BookNotAvailableException {
        BookHandler availableBooks = new BookHandler();
        BookHandler notAvailableBooks = new BookHandler();
        ReturnBookCommand returnBookCommand = new ReturnBookCommand(99);
        assertEquals("That book is not available.",returnBookCommand.loadCommand(availableBooks, notAvailableBooks));
    }
}

package com.thoughtworks.university.Biblioteca;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ReturnBookCommandTest {
    @Test
    public void shouldReturnBook() throws BookNotAvailableException {
        Book myBook = new Book("JKRowling", "HP", 1991);
        BookHandler availableBooks = new BookHandler();
        BookHandler notAvailableBooks = new BookHandler();
        notAvailableBooks.addBook(myBook);
        ReturnBookCommand returnBookCommand = new ReturnBookCommand(myBook.getID());
        returnBookCommand.setHandlers(availableBooks, notAvailableBooks);
        returnBookCommand.execute();
        assertTrue(availableBooks.getById(myBook.getID()) != null);
        assertFalse(notAvailableBooks.getById(myBook.getID()) != null);
        assertTrue(myBook.isAvailable());
    }
    @Test(expected = NullPointerException.class)
    public void shouldNotReturnBookBecauseItIsNotBorrowed() {
        BookHandler availableBooks = new BookHandler();
        BookHandler notAvailableBooks = new BookHandler();
        ReturnBookCommand returnBookCommand = new ReturnBookCommand(99);
        returnBookCommand.setHandlers(availableBooks, notAvailableBooks);
        returnBookCommand.execute();
    }
}

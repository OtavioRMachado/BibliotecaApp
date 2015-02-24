package com.thoughtworks.university.Biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BookTest {
    private Book book;
    private String title;
    private String author;
    private int date;

    @Before
    public void setUp() {
        title = "Harry Potter and the Sorcerers' Stone";
        author = "J.K. Rowling";
        date = 1991;
        book = new Book(author, title, date);
    }
    @Test
    public void shouldGetBookName() {
        assertEquals(title, book.getTitle());
    }

    @Test
    public void shouldGetBookAuthor() {
        assertEquals(author, book.getAuthor());
    }

    @Test
    public void shouldGetBookYear() {
        assertEquals(date, book.getYear());
    }

    @Test
    public void bookShouldBeAvailable() throws BookNotAvailableException {
        assertEquals(true, book.isAvailable());
        book.checkOut();
    }

    @Test(expected = BookNotAvailableException.class)
    public void bookShouldNotBeAvailable() throws BookNotAvailableException {
        ExpectedException exception = ExpectedException.none();
        exception.expect(BookNotAvailableException.class);
        book.checkOut();
        book.checkOut();
    }

    @Test
    public void shouldReturnBookSuccessfully() throws BookNotAvailableException {
        book.checkOut();
        assertFalse(book.isAvailable());
        book.returnBook();
        assertTrue(book.isAvailable());
    }
}

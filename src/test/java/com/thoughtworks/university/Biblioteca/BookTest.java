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
    private User loggedUser;

    @Before
    public void setUp() {
        title = "Harry Potter and the Sorcerers' Stone";
        author = "J.K. Rowling";
        date = 1991;
        book = new Book(author, title, date);
        loggedUser = new User("Otavio", "omachado@thoughtworks.com", "05381588006");
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
    public void bookShouldBeAvailable() throws LibraryItemNotAvailableException, UserNotLoggedInException {
        assertEquals(true, book.isAvailable());
        book.checkOut(loggedUser);
    }

    @Test(expected = LibraryItemNotAvailableException.class)
    public void bookShouldNotBeAvailable() throws LibraryItemNotAvailableException, UserNotLoggedInException {
        ExpectedException exception = ExpectedException.none();
        exception.expect(LibraryItemNotAvailableException.class);
        book.checkOut(loggedUser);
        book.checkOut(loggedUser);
    }

    @Test
    public void shouldReturnBookSuccessfully() throws LibraryItemNotAvailableException, UserNotLoggedInException {
        book.checkOut(loggedUser);
        assertFalse(book.isAvailable());
        book.returnItem(loggedUser);
        assertTrue(book.isAvailable());
    }

    @Test
    public void shouldReturnWhoIsWithTheBook() throws LibraryItemNotAvailableException, UserNotLoggedInException {
        User me = new User("Otavio", "omachado@thoughtworks.com", "05381588006");
        book.checkOut(me);
        assertEquals(me, book.WhoHas());
    }

    @Test(expected = UserNotLoggedInException.class)
    public void shouldCauseExceptionWhenUserIsNotLoggedIn() throws LibraryItemNotAvailableException, UserNotLoggedInException {
        book.checkOut(null);
    }
}

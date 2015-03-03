package com.thoughtworks.university.Biblioteca.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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
        loggedUser = new User("Otavio", "omachado@thoughtworks.com", "05381588006", "12345");
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
    }

    @Test(expected = LibraryItemNotAvailableException.class)
    public void bookShouldNotBeAvailable() throws LibraryItemNotAvailableException, UserNotLoggedInException {
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
        book.checkOut(loggedUser);

        assertEquals(loggedUser, book.WhoHas());
    }

    @Test(expected = UserNotLoggedInException.class)
    public void shouldCauseExceptionWhenUserIsNotLoggedIn() throws LibraryItemNotAvailableException, UserNotLoggedInException {
        book.checkOut(new AnonymousUser());
    }
}

package com.thoughtworks.university.Biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BookHandlerTest {
    public BookHandler bookHandler;
    public Book sampleBook;
    public Book sampleBook2;
    @Before
    public void setUp() {
        bookHandler = new BookHandler();
        sampleBook = new Book("A", "B", 2015);
        sampleBook2 = new Book("B", "A", 5102);

    }

    @Test
    public void shouldStartEmptyListedBook() {
        List<Book> bookList = bookHandler.getBooks();
        assertEquals(0, bookList.size());

    }

    @Test
    public void shouldShowFirstBooksAuthorWhenNewBookIsAdded() {
        bookHandler.addBook(sampleBook);
        List<Book> bookList = bookHandler.getBooks();
        assertEquals(bookList.get(0).getTitle(), "B");
    }

    @Test
    public void shouldShowOneBookInListAfterAddingTwoBooksAndDeletingOneOfThem() {
        bookHandler.addBook(sampleBook);
        bookHandler.addBook(sampleBook2);
        List<Book> bookList = bookHandler.getBooks();
        assertEquals(2, bookList.size());
        bookHandler.removeBook(sampleBook);
        assertEquals(1, bookList.size());
    }

    @Test
    public void shouldReturnBookById() {
        bookHandler.addBook(sampleBook);
        bookHandler.addBook(sampleBook2);
        int bookID = sampleBook.getID();
        assertEquals(sampleBook, bookHandler.getById(bookID));
    }

    @Test
    public void shouldNotReturnBookBecauseIDIsWrong() {
        bookHandler.addBook(sampleBook);
        int bookID = 99;
        assertEquals(null, bookHandler.getById(99));
    }
}

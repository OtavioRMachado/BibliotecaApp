package com.thoughtworks.university.Biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ListBookTest {
    private BookHandler bookList;
    @Before
    public void setUp() {
        Book sampleBook = new Book("J.K. Rowling", "Harry Potter", 1991);
        Book sampleBook2 = new Book("J.R.R Tolkien", "Lord of The Rings", 1990);
        bookList = new BookHandler();
        bookList.addBook(sampleBook);
        bookList.addBook(sampleBook2);
    }
    @Test
    public void shouldShowAvailableBooksList() {
        StreamControl streamControl = new StreamControl();
        streamControl.setUpOut();
        ListBooksCommand listBooksCommand = new ListBooksCommand();
        listBooksCommand.loadBookList(bookList);
        listBooksCommand.execute();
        String expectedResult = "List of Biblioteca's available books:\n(1) Harry Potter - J.K. Rowling (1991)\n" +
                "(2) Lord of The Rings - J.R.R Tolkien (1990)\n"+"To get a book, type CHECKOUT BOOK-NUMBER.\n";
        assertEquals(expectedResult, streamControl.getOutput());
        streamControl.cleanUpStreams();
    }
}

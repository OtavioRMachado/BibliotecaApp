package com.thoughtworks.university.Biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ListBookTest {
    private ItemHandler bookList;
    @Before
    public void setUp() {
        Book sampleBook = new Book("J.K. Rowling", "Harry Potter", 1991);
        Book sampleBook2 = new Book("J.R.R Tolkien", "Lord of The Rings", 1990);
        bookList = new ItemHandler();
        bookList.addItem(sampleBook);
        bookList.addItem(sampleBook2);
    }
    @Test
    public void shouldShowAvailableBooksList() throws LibraryItemNotAvailableException {
        User user = new User("Otavio", "omachado@thoughtworks.com", "05381588006");
        StreamControl streamControl = new StreamControl();
        streamControl.setUpOut();
        ListBooksCommand listBooksCommand = new ListBooksCommand();
        listBooksCommand.loadCommand(bookList, new ItemHandler(), new ArrayList<String>(), user);
        String expectedResult = "List of Biblioteca's available books:\n(1) Harry Potter - J.K. Rowling (1991)\n" +
                "(2) Lord of The Rings - J.R.R Tolkien (1990)\n"+"To get a book, type CHECKOUT BOOK-NUMBER.";
        assertEquals(expectedResult, listBooksCommand.execute());
        streamControl.cleanUpStreams();
    }
}

package com.thoughtworks.university.Biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ListBookTest {
    private ArrayList<LibraryItem> bookList;
    private Book sampleBook;
    private Book sampleBook2;

    @Before
    public void setUp() {
        sampleBook = new Book("J.K. Rowling", "Harry Potter", 1991);
        sampleBook2 = new Book("J.R.R Tolkien", "Lord of The Rings", 1990);
        bookList = new ArrayList<LibraryItem>();
        bookList.add(sampleBook);
        bookList.add(sampleBook2);
    }
    @Test
    public void shouldShowAvailableBooksList() throws LibraryItemNotAvailableException {
        User user = new User("Otavio", "omachado@thoughtworks.com", "05381588006", "12345");
        StreamControl streamControl = new StreamControl();
        streamControl.setUpOut();
        ListBooksCommand listBooksCommand = new ListBooksCommand();
        listBooksCommand.loadCommand(bookList, new ArrayList<LibraryItem>(), new ArrayList<String>(), user);
        String expectedResult = listBooksCommand.toString();
        assertEquals(listBooksCommand.toString(), listBooksCommand.execute());
        streamControl.cleanUpStreams();
    }
}

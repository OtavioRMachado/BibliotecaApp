package com.thoughtworks.university.Biblioteca.domain;

import com.thoughtworks.university.Biblioteca.command.ListBooksCommand;
import com.thoughtworks.university.Biblioteca.domain.*;
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
        ListBooksCommand listBooksCommand = new ListBooksCommand();

        String result = listBooksCommand.execute(bookList, new ArrayList<LibraryItem>(), new ArrayList<String>(), user);

        assertEquals(listBooksCommand.toString(), result);
    }
}

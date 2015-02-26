package com.thoughtworks.university.Biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ItemHandlerTest {
    private ItemHandler itemHandler;
    private Book sampleBook;
    private Book sampleBook2;
    @Before
    public void setUp() {
        itemHandler = new ItemHandler();
        sampleBook = new Book("A", "B", 2015);
        sampleBook2 = new Book("B", "A", 5102);

    }

    @Test
    public void shouldStartEmptyListedBook() {
        List<LibraryItem> bookList = itemHandler.getLibraryItems();
        assertEquals(0, bookList.size());

    }

    @Test
    public void shouldShowFirstBooksAuthorWhenNewBookIsAdded() {
        itemHandler.addItem(sampleBook);
        List<LibraryItem> bookList = itemHandler.getLibraryItems();
        assertEquals(bookList.get(0), sampleBook);
    }

    @Test
    public void shouldShowOneBookInListAfterAddingTwoBooksAndDeletingOneOfThem() {
        itemHandler.addItem(sampleBook);
        itemHandler.addItem(sampleBook2);
        List<LibraryItem> bookList = itemHandler.getLibraryItems();
        assertEquals(2, bookList.size());
        itemHandler.removeItem(sampleBook);
        assertEquals(1, bookList.size());
        assertEquals(bookList.get(0), sampleBook2);
    }

    @Test
    public void shouldReturnBookById() {
        itemHandler.addItem(sampleBook);
        itemHandler.addItem(sampleBook2);
        int bookID = sampleBook.getID();
        assertEquals(sampleBook, itemHandler.getById(bookID));
    }

    @Test
    public void shouldNotReturnBookBecauseIDIsWrong() {
        itemHandler.addItem(sampleBook);
        int bookID = 99;
        assertEquals(null, itemHandler.getById(bookID));
    }
}

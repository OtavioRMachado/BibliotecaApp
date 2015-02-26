package com.thoughtworks.university.Biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListMoviesCommandTest {
    @Test
    public void shouldReturnNothingWhenTheListIsEmpty() throws UserNotLoggedInException, LibraryItemNotAvailableException {
        ListMoviesCommand listMoviesCommand = new ListMoviesCommand();
        String result = listMoviesCommand.loadCommand(new ArrayList<LibraryItem>(), new ArrayList<LibraryItem>(), new ArrayList<String>(), new AnonymousUser());
<<<<<<< HEAD
        assertEquals(listMoviesCommand.toString(), result);
=======
        assertEquals("Our movie list is:\n", result);
>>>>>>> abfa025a4c8e07a43fbd556d4dfa21ad46e1a990
    }

    @Test
    public void shouldReturnOneEntryWhenTheListHasOneMovie() throws UserNotLoggedInException, LibraryItemNotAvailableException {
        ListMoviesCommand listMoviesCommand = new ListMoviesCommand();
        List<LibraryItem> availableItems = new ArrayList<LibraryItem>();
        Movie myMovie = new Movie("Silence of the Lambs", 1991, "Jonathan Demme");
        availableItems.add(myMovie);
        String result = listMoviesCommand.loadCommand(availableItems, new ArrayList<LibraryItem>(), new ArrayList<String>(), new AnonymousUser());
<<<<<<< HEAD
        assertEquals(listMoviesCommand.toString(), result);
=======
        String expectedResult = String.format("Our movie list is:\n%s", myMovie.toString());
        assertEquals(expectedResult, result);
>>>>>>> abfa025a4c8e07a43fbd556d4dfa21ad46e1a990
    }
}

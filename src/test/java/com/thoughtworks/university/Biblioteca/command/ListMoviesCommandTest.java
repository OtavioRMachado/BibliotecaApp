package com.thoughtworks.university.Biblioteca.command;

import com.thoughtworks.university.Biblioteca.domain.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListMoviesCommandTest {
    @Test
    public void shouldReturnNothingWhenTheListIsEmpty() throws UserNotLoggedInException, LibraryItemNotAvailableException {
        ListMoviesCommand listMoviesCommand = new ListMoviesCommand();

        String result = listMoviesCommand.execute(new ArrayList<LibraryItem>(), new ArrayList<LibraryItem>(), new ArrayList<String>(), new AnonymousUser());

        assertEquals(listMoviesCommand.toString(), result);
    }

    @Test
    public void shouldReturnOneEntryWhenTheListHasOneMovie() throws UserNotLoggedInException, LibraryItemNotAvailableException {
        ListMoviesCommand listMoviesCommand = new ListMoviesCommand();
        List<LibraryItem> availableItems = new ArrayList<LibraryItem>();
        Movie myMovie = new Movie("Silence of the Lambs", 1991, "Jonathan Demme");

        availableItems.add(myMovie);
        String result = listMoviesCommand.execute(availableItems, new ArrayList<LibraryItem>(), new ArrayList<String>(), new AnonymousUser());

        assertEquals(listMoviesCommand.toString(), result);
    }
}

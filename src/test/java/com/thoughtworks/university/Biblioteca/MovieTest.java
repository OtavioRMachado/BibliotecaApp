package com.thoughtworks.university.Biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MovieTest {
    Movie myMovie;
    String title;
    int year;
    String director;
    double rating;
    User loggedUser;

    @Before
    public void setUp() throws RatingOutOfBounds {
        title = "Title";
        year = 1991;
        director = "Director";
        rating = 9.5;
        myMovie = new Movie(title, year, director);
        myMovie.setRating(rating);
        loggedUser = new User("Otavio", "omachado@thoughtworks.com", "05381588006");
    }
    @Test
    public void shouldReturnMovieTitle() {
        assertEquals(title, myMovie.getTitle());
    }

    @Test
    public void shouldReturnMovieInformation() {
        assertEquals(year, myMovie.getYear());
        assertEquals(director, myMovie.getDirector());
        assertEquals(new StringBuilder().append(rating).toString(), myMovie.getRating());
    }

    @Test
    public void shouldReturnUnratedWhenMovieIsNotRated() {
        Movie unratedMovie = new Movie("Silence of the Lambs", 1991, "Jonathan Demme");
        assertEquals("UNRATED", unratedMovie.getRating());
    }

    @Test
    public void shouldReturnTrueWhenMovieIsAvailable() {
        assertTrue(myMovie.isAvailable());
    }

    @Test
    public void shouldReturnFalseWhenMovieIsNotAvailable() throws LibraryItemNotAvailableException, UserNotLoggedInException {
        myMovie.checkOut(loggedUser);
        assertFalse(myMovie.isAvailable());
    }

    @Test(expected = LibraryItemNotAvailableException.class)
    public void shouldThrowExceptionWhenCheckingOutNotAvailableMovie() throws LibraryItemNotAvailableException, UserNotLoggedInException {
        myMovie.checkOut(loggedUser);
        myMovie.checkOut(loggedUser);
    }

    @Test(expected = RatingOutOfBounds.class)
    public void shouldNotAcceptMovieOutOfRatingBounds() throws RatingOutOfBounds {
        Movie errorMovie = new Movie("Title", 1970, "Director");
        errorMovie.setRating(11.0);
    }
}

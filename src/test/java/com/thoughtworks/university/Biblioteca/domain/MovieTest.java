package com.thoughtworks.university.Biblioteca.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {
    private Movie myMovie;
    private String title;
    private int year;
    private String director;
    private double rating;
    private User loggedUser;

    @Before
    public void setUp() throws RatingOutOfBounds {
        title = "Title";
        year = 1991;
        director = "Director";
        rating = 9.5;
        myMovie = new Movie(title, year, director);
        myMovie.setRating(rating);
        loggedUser = new User("Otavio", "omachado@thoughtworks.com", "05381588006", "12345");
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

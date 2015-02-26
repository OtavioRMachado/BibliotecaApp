package com.thoughtworks.university.Biblioteca;

public class Movie extends LibraryItem {
    private static final double MAX_RATING = 10.0;
    private static final double MIN_RATING = 0.0;
    private static final double UNRATED = -1.0;
    private double rating;

    public Movie(String title, int year, String director) {
        super(title, director, year);
        this.rating = UNRATED;
    }

    private boolean ratingIsOutOfBounds(double rating) {
        if(rating > MAX_RATING || rating < MIN_RATING) {
            return true;
        }
        return false;
    }

    public String getDirector() {
        return author;
    }

    public String getRating() {
        if(rating == UNRATED)
            return "UNRATED";
        return new StringBuilder().append(rating).toString();
    }

    public void setRating(double rating) throws RatingOutOfBounds {
        if (ratingIsOutOfBounds(rating)) {
            throw new RatingOutOfBounds();
        }
        this.rating = rating;
    }


    @Override
    public String toString() {
        return String.format("(%d) %s - %s (%d) - %s", getID(), getTitle(), getDirector(), getYear(), getRating());
    }

    @Override
    public String getClassName() {
        return "Movie";
    }
}

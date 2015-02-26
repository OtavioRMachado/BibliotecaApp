package com.thoughtworks.university.Biblioteca;

public class RatingOutOfBounds extends Exception {
    public RatingOutOfBounds() {
        super();
    }

    @Override
    public String getMessage() {
        return "Error: Rating Out of Bounds.";
    }
}

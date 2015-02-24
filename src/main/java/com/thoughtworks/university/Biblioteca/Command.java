package com.thoughtworks.university.Biblioteca;

public abstract class Command {
    protected abstract String execute() throws BookNotAvailableException;
    public abstract String loadCommand(BookHandler availableBooks, BookHandler borrowedBooks) throws BookNotAvailableException;
}

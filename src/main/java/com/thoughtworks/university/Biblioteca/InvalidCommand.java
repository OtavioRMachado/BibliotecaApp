package com.thoughtworks.university.Biblioteca;

public class InvalidCommand extends Command {
    protected final String message = "Error: Invalid command! To see commands, type OPTIONS";
    @Override
    public String execute() {
        return message;
    }

    @Override
    public String loadCommand(BookHandler availableBooks, BookHandler borrowedBooks) throws BookNotAvailableException {
        return execute();
    }
}

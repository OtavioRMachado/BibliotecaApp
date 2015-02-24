package com.thoughtworks.university.Biblioteca;

public class ReturnBookCommand extends Command {
    public static String commandName = "return";
    private BookHandler availableBooks;
    private BookHandler borrowedBooks;
    private Book desiredBook;
    private int bookID;
    private final String successMessage = "Thank you for returning the book.";
    private final String failureMessage = "That book is not available.";

    @Override
    public String execute() {
        try {
            desiredBook = borrowedBooks.getById(bookID);
            desiredBook.returnBook();
            borrowedBooks.removeBook(desiredBook);
            availableBooks.addBook(desiredBook);
        }
        catch(NullPointerException nullPointerExc) {
            return failureMessage;
        }
        return successMessage;
    }

    @Override
    public String loadCommand(BookHandler availableBooks, BookHandler borrowedBooks) throws BookNotAvailableException {
        this.availableBooks = availableBooks;
        this.borrowedBooks = borrowedBooks;
        return execute();
    }

    public ReturnBookCommand(int value) {
        bookID = value;
    }

    public static String getCommandName() {
        return commandName;
    }
}

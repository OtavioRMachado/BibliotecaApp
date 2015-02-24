package com.thoughtworks.university.Biblioteca;

public class CheckoutCommand extends Command {
    private static final String commandName = "checkout";
    private BookHandler availableBooks;
    private BookHandler borrowedBooks;
    private Book desiredBook;
    private int bookID;
    private static final String successMessage = "Thank you! Enjoy the book.";
    public CheckoutCommand(int bookID) {
        this.bookID = bookID;
    }

    @Override
    protected String execute() throws BookNotAvailableException {
        try {
            desiredBook = availableBooks.getById(bookID);
            desiredBook.checkOut();
            availableBooks.removeBook(desiredBook);
            borrowedBooks.addBook(desiredBook);
        }
        catch(BookNotAvailableException exception) {
            throw new BookNotAvailableException();
        }
        catch(NullPointerException nullPointerExc) {
            new InvalidCommand().execute();
            throw new NullPointerException();
        }
        return successMessage;
    }

    @Override
    public String loadCommand(BookHandler availableBooks, BookHandler borrowedBooks) throws BookNotAvailableException {
        this.availableBooks = availableBooks;
        this.borrowedBooks = borrowedBooks;
        String message = execute();
        return message;
    }

    public static String getCommandName() {
        return commandName;
    }
}

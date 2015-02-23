package com.thoughtworks.university.Biblioteca;

public class CheckoutCommand extends Command {
    protected static final String commandName = "checkout";
    protected BookHandler availableBooks;
    protected BookHandler borrowedBooks;
    protected Book desiredBook;
    protected int bookID;
    @Override
    public void execute() throws BookNotAvailableException {
        try {
            desiredBook = availableBooks.getById(bookID);
            desiredBook.checkOut();
            availableBooks.removeBook(desiredBook);
            borrowedBooks.addBook(desiredBook);
            System.out.println("Thank you! Enjoy the book.");
        }
        catch(BookNotAvailableException exception) {
            throw new BookNotAvailableException();
        }
        catch(NullPointerException nullPointerExc) {
            new InvalidCommand().execute();
        }
    }

    public CheckoutCommand(int value) {
        bookID = value;
    }

    public void setHandlers(BookHandler availableBooks, BookHandler borrowedBooks)
    {
        this.availableBooks = availableBooks;
        this.borrowedBooks = borrowedBooks;
    }



    public static String getCommandName() {
        return commandName;
    }
}

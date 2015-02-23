package com.thoughtworks.university.Biblioteca;

public class ReturnBookCommand extends Command {
    public static String commandName = "return";
    private BookHandler availableBooks;
    private BookHandler borrowedBooks;
    private Book desiredBook;
    private int bookID;

    @Override
    public void execute() {
        try {
            desiredBook = borrowedBooks.getById(bookID);
            desiredBook.returnBook();
            borrowedBooks.removeBook(desiredBook);
            availableBooks.addBook(desiredBook);
        }
        catch(NullPointerException nullPointerExc) {
            new InvalidCommand().execute();
        }
    }

    public void setHandlers(BookHandler availableBooks, BookHandler borrowedBooks)
    {
        this.availableBooks = availableBooks;
        this.borrowedBooks = borrowedBooks;
    }

    public ReturnBookCommand(int value) {
        bookID = value;
    }

    public static String getCommandName() {
        return commandName;
    }
}

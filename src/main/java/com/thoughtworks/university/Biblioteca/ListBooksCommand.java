package com.thoughtworks.university.Biblioteca;

public class ListBooksCommand extends Command {
    public static String command = "LIST BOOKS";
    private static final String commandName = "list books";
    protected BookHandler bookList;
    private StringBuilder message;
    @Override
    public String execute() {
        Book usedBook;
        message = new StringBuilder();
        message.append("List of Biblioteca's available books:\n");
        for(int i = 0; i < bookList.size(); i++) {
            usedBook = bookList.getBook(i);
            message.append("(" + (i + 1) + ") " + usedBook.getTitle() + " - " + usedBook.getAuthor() + " (" + usedBook.getYear() + ")\n");
        }
        message.append("To get a book, type CHECKOUT BOOK-NUMBER.");
        return message.toString();
    }

    @Override
    public String loadCommand(BookHandler availableBooks, BookHandler borrowedBooks) throws BookNotAvailableException {
        loadBookList(availableBooks);
        return execute();
    }

    public void loadBookList(BookHandler bookList) {
        this.bookList = bookList;
    }
    public static String getCommandName() {
        return commandName;
    }
}

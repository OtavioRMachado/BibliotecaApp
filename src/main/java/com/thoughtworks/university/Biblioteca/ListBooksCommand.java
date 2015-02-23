package com.thoughtworks.university.Biblioteca;

public class ListBooksCommand extends Command {
    public static String command = "LIST BOOKS";
    private static final String commandName = "list books";
    protected BookHandler bookList;
    @Override
    public void execute() {
        Book usedBook;
        System.out.println("List of Biblioteca's available books:");
        for(int i = 0; i < bookList.size(); i++) {
            usedBook = bookList.getBook(i);
            System.out.println( "(" + (i+1) + ") " + usedBook.getTitle() + " - " + usedBook.getAuthor() + " (" + usedBook.getYear() + ")");
        }
        System.out.println("To get a book, type CHECKOUT BOOK-NUMBER.");
    }

    public void loadBookList(BookHandler bookList) {
        this.bookList = bookList;
    }
    public static String getCommandName() {
        return commandName;
    }
}

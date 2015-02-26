package com.thoughtworks.university.Biblioteca;

public class Book extends LibraryItem {

    public Book(String author, String title, int year) {
        super(title, author, year);
    }

    public String getAuthor() {
        return author;
    }

<<<<<<< HEAD

    @Override
    public String toString() {
        return String.format("(%d) %s - %s (%d)", uniqueID, title, author, year);
    }

    @Override
    public String getClassName() {
        return "Book";
=======

    @Override
    public String toString() {
        return String.format("(%d) %s - %s (%d)", uniqueID, title, author, year);
>>>>>>> abfa025a4c8e07a43fbd556d4dfa21ad46e1a990
    }
}

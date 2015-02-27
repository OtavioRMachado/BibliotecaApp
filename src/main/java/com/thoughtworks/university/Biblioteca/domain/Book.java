package com.thoughtworks.university.Biblioteca.domain;

public class Book extends LibraryItem {

    public Book(String author, String title, int year) {
        super(title, author, year);
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return String.format("(%d) %s - %s (%d)", uniqueID, title, author, year);
    }

}

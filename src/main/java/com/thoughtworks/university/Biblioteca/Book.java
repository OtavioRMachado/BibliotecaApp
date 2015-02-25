package com.thoughtworks.university.Biblioteca;

public class Book extends LibraryItem {

    public Book(String author, String title, int year) {
        super(title, author, year);
    }

    public String getAuthor() {
        return author;
    }

}

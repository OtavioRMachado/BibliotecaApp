package com.thoughtworks.university.Biblioteca;

public class Book {
    private String title;

    private String author;

    private int year;
    private boolean available;

    public boolean isAvailable() {
        return available;
    }
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public Book(String author, String title, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = true;
    }


    public void checkOut() throws BookNotAvailableException {
        if(!isAvailable()) {
            throw new BookNotAvailableException();
        } else {
            this.available = false;
        }

    }
}

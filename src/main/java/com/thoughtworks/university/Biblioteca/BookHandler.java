package com.thoughtworks.university.Biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BookHandler {
    List<Book> books;

    public BookHandler() {
        books = new ArrayList<Book>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public int size() {
        return books.size();
    }

    public Book getBook(int position) {
        return books.get(position);
    }

    public Book getById(int id) {
        for (int i = 0; i < books.size(); i++) {
            if(books.get(i).getID() == id) {
                return books.get(i);
            }
        }
        return null;
    }
}

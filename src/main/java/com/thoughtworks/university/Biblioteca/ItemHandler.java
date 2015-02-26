package com.thoughtworks.university.Biblioteca;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ItemHandler {
    List<LibraryItem> libraryItems;

    public ItemHandler() {
        libraryItems = new ArrayList<LibraryItem>();
    }

    public void addItem(LibraryItem libraryItem) {
        libraryItems.add(libraryItem);
    }

    public void removeItem(LibraryItem libraryItem) {
        libraryItems.remove(libraryItem);
    }

    public List<LibraryItem> getLibraryItems() {
        return libraryItems;
    }

    public int size() {
        return libraryItems.size();
    }

    public LibraryItem getLibraryItem(int position) {
        return libraryItems.get(position);
    }

    public LibraryItem getById(int id) {
        for (int i = 0; i < libraryItems.size(); i++) {
            if(libraryItems.get(i).getID() == id) {
                return libraryItems.get(i);
            }
        }
        return null;
    }
}

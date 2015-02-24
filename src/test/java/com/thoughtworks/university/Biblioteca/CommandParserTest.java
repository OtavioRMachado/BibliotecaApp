package com.thoughtworks.university.Biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class CommandParserTest {
    private List<String> menuItems;
    private BookHandler availableBooks;
    private BookHandler borrowedBooks;

    @Before
    public void setup() {
        menuItems = new ArrayList<String>();
        availableBooks = new BookHandler();
        borrowedBooks = new BookHandler();
    }

    @Test
    public void shouldReturnInvalidCommand() {
        assertTrue(CommandParser.parseCommand("ugabuga", availableBooks, borrowedBooks, menuItems) instanceof InvalidCommand);
    }

    @Test
    public void shouldReturnOptionsCommand() {
        assertTrue(CommandParser.parseCommand("options", availableBooks, borrowedBooks, menuItems) instanceof OptionsCommand);
        assertTrue(CommandParser.parseCommand("OPTIONS", availableBooks, borrowedBooks, menuItems) instanceof OptionsCommand);
    }

    @Test
    public void shouldReturnQuitCommand() {
        assertTrue(CommandParser.parseCommand("quit", availableBooks, borrowedBooks, menuItems) instanceof QuitCommand);
        assertTrue(CommandParser.parseCommand("QUIT", availableBooks, borrowedBooks, menuItems) instanceof QuitCommand);
    }

    @Test
    public void shouldReturnReturnBookCommand() {
        assertTrue(CommandParser.parseCommand("return 1", availableBooks, borrowedBooks, menuItems) instanceof ReturnBookCommand);
    }

    @Test
    public void shouldReturnCheckoutCommand() {
        assertTrue(CommandParser.parseCommand("CheckOut 1", availableBooks, borrowedBooks, menuItems) instanceof CheckoutCommand);
    }
}

package com.thoughtworks.university.Biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class CommandParserTest {
    private List<String> menuItems;

    @Before
    public void setup() {
        menuItems = new ArrayList<String>();
    }

    @Test
    public void shouldReturnInvalidCommand() {
        assertTrue(CommandParser.parseCommand("ugabuga", menuItems) instanceof InvalidCommand);
    }

    @Test
    public void shouldReturnOptionsCommand() {
        assertTrue(CommandParser.parseCommand("options", menuItems) instanceof OptionsCommand);
        assertTrue(CommandParser.parseCommand("OPTIONS", menuItems) instanceof OptionsCommand);
    }

    @Test
    public void shouldReturnQuitCommand() {
        assertTrue(CommandParser.parseCommand("quit", menuItems) instanceof QuitCommand);
        assertTrue(CommandParser.parseCommand("QUIT", menuItems) instanceof QuitCommand);
    }

    @Test
    public void shouldReturnReturnBookCommand() {
        assertTrue(CommandParser.parseCommand("return 1", menuItems) instanceof ReturnBookCommand);
    }

    @Test
    public void shouldReturnCheckoutCommand() {
        assertTrue(CommandParser.parseCommand("CheckOut 1", menuItems) instanceof CheckoutCommand);
    }
}

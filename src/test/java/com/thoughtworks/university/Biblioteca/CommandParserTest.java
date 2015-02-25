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
        assertTrue(CommandParser.parseCommand("ugabuga") instanceof InvalidCommand);
    }

    @Test
    public void shouldReturnOptionsCommand() {
        assertTrue(CommandParser.parseCommand("options") instanceof OptionsCommand);
        assertTrue(CommandParser.parseCommand("OPTIONS") instanceof OptionsCommand);
    }

    @Test
    public void shouldReturnQuitCommand() {
        assertTrue(CommandParser.parseCommand("quit") instanceof QuitCommand);
        assertTrue(CommandParser.parseCommand("QUIT") instanceof QuitCommand);
    }

    @Test
    public void shouldReturnReturnBookCommand() {
        assertTrue(CommandParser.parseCommand("return 1") instanceof ReturnItemCommand);
    }

    @Test
    public void shouldReturnCheckoutCommand() {
        assertTrue(CommandParser.parseCommand("CheckOut 1") instanceof CheckoutCommand);
    }
}

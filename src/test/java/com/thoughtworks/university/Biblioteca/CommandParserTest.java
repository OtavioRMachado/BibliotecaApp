package com.thoughtworks.university.Biblioteca;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.DynAnyPackage.Invalid;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CommandParserTest {
    @Before
    public void setup() {

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
        assertTrue(CommandParser.parseCommand("return") instanceof ReturnBookCommand);
    }

    @Test
    public void shouldReturnCheckoutCommand() {
        assertTrue(CommandParser.parseCommand("CheckOut") instanceof CheckoutCommand);
    }
}

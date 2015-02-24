package com.thoughtworks.university.Biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InvalidCommandTest {
    @Test
    public void shouldReturnInvalidCommandMessageWhenExecuted() throws BookNotAvailableException {
        InvalidCommand invalidCommand = new InvalidCommand();
        assertEquals("Error: Invalid command! To see commands, type OPTIONS", invalidCommand.loadCommand(new BookHandler(), new BookHandler()));
    }
}

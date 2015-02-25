package com.thoughtworks.university.Biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class InvalidCommandTest {
    @Test
    public void shouldReturnInvalidCommandMessageWhenExecuted() throws LibraryItemNotAvailableException {
        InvalidCommand invalidCommand = new InvalidCommand();
        assertEquals("Error: Invalid command! To see commands, type OPTIONS", invalidCommand.loadCommand(new ItemHandler(), new ItemHandler(), new ArrayList<String>(), null));
    }
}

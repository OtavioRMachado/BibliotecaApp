package com.thoughtworks.university.Biblioteca.command;

import com.thoughtworks.university.Biblioteca.command.InvalidCommand;
import com.thoughtworks.university.Biblioteca.domain.LibraryItem;
import com.thoughtworks.university.Biblioteca.domain.LibraryItemNotAvailableException;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class InvalidCommandTest {
    @Test
    public void shouldReturnInvalidCommandMessageWhenExecuted() throws LibraryItemNotAvailableException {
        InvalidCommand invalidCommand = new InvalidCommand();
        assertEquals("Error: Invalid command! To see commands, type OPTIONS", invalidCommand.execute(new ArrayList<LibraryItem>(), new ArrayList<LibraryItem>(), new ArrayList<String>(), null));
    }
}

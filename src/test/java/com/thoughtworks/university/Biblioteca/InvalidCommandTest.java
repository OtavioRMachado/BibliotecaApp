package com.thoughtworks.university.Biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class InvalidCommandTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    @Test
    public void shouldReturnInvalidCommandMessageWhenExecuted() {
        StreamControl streamControl = new StreamControl();
        streamControl.setUpOut();
        InvalidCommand invalidCommand = new InvalidCommand();
        invalidCommand.execute();
        assertEquals("Error: Invalid command! To see commands, type OPTIONS\n", streamControl.getOutput());
        streamControl.cleanUpStreams();
    }
}

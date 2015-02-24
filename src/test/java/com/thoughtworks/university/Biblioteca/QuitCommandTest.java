package com.thoughtworks.university.Biblioteca;


import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class QuitCommandTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Test
    public void shouldSendMeAFarewell() throws BookNotAvailableException {
        Command quit = new QuitCommand();
        assertEquals("Goodbye!", quit.execute());
    }
}

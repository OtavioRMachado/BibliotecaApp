package com.thoughtworks.university.Biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class QuitCommandTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Test
    public void shouldSendMeAFarewell() {
        setUpStreams();
        Command quit = new QuitCommand();
        quit.execute();
        assertEquals("Goodbye!", outContent.toString());
        cleanUpStreams();
    }
    private void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    private void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }
}

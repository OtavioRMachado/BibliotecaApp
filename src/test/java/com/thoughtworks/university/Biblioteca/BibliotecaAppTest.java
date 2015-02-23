package com.thoughtworks.university.Biblioteca;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Test
    public void shouldWelcomeMeWhenIRunTheApp() throws BookNotAvailableException {
        StreamControl stream = new StreamControl();
        stream.setUpOut();
        stream.setUpIn("Quit");
        BibliotecaApp.main(null);
        assertEquals("Welcome to our Virtual Bangalore Biblioteca. To see the available commands, please type OPTIONS\nGoodbye!", stream.getOutput());
        System.setIn(null);
        stream.cleanUpStreams();
    }
}

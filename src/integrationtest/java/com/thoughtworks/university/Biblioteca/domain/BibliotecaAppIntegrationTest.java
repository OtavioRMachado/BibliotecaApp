package com.thoughtworks.university.Biblioteca.domain;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppIntegrationTest {
    ByteArrayOutputStream myOut;
    ByteArrayOutputStream myErr;
    InputStream newIn;
    @Before
    public void setUp() {
        myOut = new ByteArrayOutputStream();
        myErr = new ByteArrayOutputStream();
    }
    @Test
    public void shouldShowMeMyWelcomeMessageAndQuit() throws UserNotLoggedInException, LibraryItemNotAvailableException, FileNotFoundException {
        newIn = new ByteArrayInputStream("quit".getBytes());

        System.setOut(new PrintStream(myOut));
        System.setErr(new PrintStream(myErr));
        System.setIn(newIn);

        BibliotecaApp.main(null);

        assertEquals("Welcome to our Virtual Bangalore Biblioteca. To see the available commands, please type OPTIONS\n" +
                "Goodbye!\n", myOut.toString());
    }

    @Test
    public void shouldShowMeAListOfBooks() throws UserNotLoggedInException, LibraryItemNotAvailableException, FileNotFoundException {
        newIn = new ByteArrayInputStream("list books\nquit".getBytes());

        System.setOut(new PrintStream(myOut));
        System.setErr(new PrintStream(myErr));
        System.setIn(newIn);

        BibliotecaApp.main(null);
        assertEquals("", myOut);
    }

}

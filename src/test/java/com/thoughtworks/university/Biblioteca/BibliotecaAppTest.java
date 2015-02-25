package com.thoughtworks.university.Biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {
    @Test
    public void shouldWelcomeMeWhenIRunTheApp() throws LibraryItemNotAvailableException, UserNotLoggedInException {
        StreamControl stream = new StreamControl();
        stream.setUpOut();
        stream.setUpIn("Quit");
        BibliotecaApp.main(null);
        assertEquals("Welcome to our Virtual Bangalore Biblioteca. To see the available commands, please type OPTIONS\nGoodbye!\n", stream.getOutput());
        System.setIn(null);
        stream.cleanUpStreams();
    }
}

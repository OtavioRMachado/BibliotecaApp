package com.thoughtworks.university.Biblioteca.command;

import com.thoughtworks.university.Biblioteca.domain.AnonymousUser;
import com.thoughtworks.university.Biblioteca.domain.LibraryItem;
import com.thoughtworks.university.Biblioteca.domain.LibraryItemNotAvailableException;
import com.thoughtworks.university.Biblioteca.domain.UserNotLoggedInException;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class QuitCommandTest {
    @Test
    public void shouldSendMeAFarewell() throws LibraryItemNotAvailableException, UserNotLoggedInException {
        Command quit = new QuitCommand();

        assertEquals("Goodbye!", quit.execute(new ArrayList<LibraryItem>(), new ArrayList<LibraryItem>(), new ArrayList<String>(), new AnonymousUser()));
    }
}

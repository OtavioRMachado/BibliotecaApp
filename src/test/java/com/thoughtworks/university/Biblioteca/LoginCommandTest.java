package com.thoughtworks.university.Biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class LoginCommandTest {
    @Test
    public void shouldLogInAndReturnUserWhenIDAndPasswordAreCorrect() throws UserNotLoggedInException, LibraryItemNotAvailableException {
        LoginCommand loginCommand = new LoginCommand("123-4567", "12345");
        User loggedUser = new User();
        loginCommand.loadCommand(new ArrayList<LibraryItem>(), new ArrayList<LibraryItem>(), new ArrayList<String>(), loggedUser);
        assertTrue(loggedUser.getName() != null);
    }
}
package com.thoughtworks.university.Biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class LoginCommandTest {
    @Test
    public void shouldLogInAndReturnUserWhenIDAndPasswordAreCorrect() throws UserNotLoggedInException, LibraryItemNotAvailableException {
        LoginCommand loginCommand = new LoginCommand("123-4567", "12345");
        User loggedUser = new AnonymousUser();
        loginCommand.loadCommand(new ArrayList<LibraryItem>(), new ArrayList<LibraryItem>(), new ArrayList<String>(), loggedUser);
        assertTrue(loggedUser.getName() != "");
    }
<<<<<<< HEAD

    @Test
    public void shouldNotLogInAndTellUserIsWrong() throws UserNotLoggedInException, LibraryItemNotAvailableException {
        LoginCommand loginCommand = new LoginCommand("123", "123");
        User loggedUser = new AnonymousUser();
        loginCommand.loadCommand(new ArrayList<LibraryItem>(), new ArrayList<LibraryItem>(), new ArrayList<String>(), loggedUser);
        assertTrue(loggedUser.getName() == "");
    }
=======
>>>>>>> abfa025a4c8e07a43fbd556d4dfa21ad46e1a990
}

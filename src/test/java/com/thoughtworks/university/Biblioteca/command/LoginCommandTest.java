package com.thoughtworks.university.Biblioteca.command;

import com.thoughtworks.university.Biblioteca.domain.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class LoginCommandTest {
    User loggedUser;
    @Before
    public void setUp() {
        loggedUser = new AnonymousUser();
    }
    @Test
    public void shouldLogInAndReturnUserWhenIDAndPasswordAreCorrect() throws UserNotLoggedInException, LibraryItemNotAvailableException {
        LoginCommand loginCommand = new LoginCommand("123-4567", "12345");

        loginCommand.execute(new ArrayList<LibraryItem>(), new ArrayList<LibraryItem>(), new ArrayList<String>(), loggedUser);

        assertTrue(loggedUser.getName() != "");
    }

    @Test
    public void shouldNotLogInAndTellUserIsWrong() throws UserNotLoggedInException, LibraryItemNotAvailableException {
        LoginCommand loginCommand = new LoginCommand("123", "123");

        loginCommand.execute(new ArrayList<LibraryItem>(), new ArrayList<LibraryItem>(), new ArrayList<String>(), loggedUser);

        assertTrue(loggedUser.getName() == "");
    }
}

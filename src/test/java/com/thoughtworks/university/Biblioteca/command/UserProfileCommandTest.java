package com.thoughtworks.university.Biblioteca.command;

import com.thoughtworks.university.Biblioteca.domain.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class UserProfileCommandTest {
    @Test
    public void shouldReturnErrorWhenNotLoggedIn() throws UserNotLoggedInException, LibraryItemNotAvailableException {
        UserProfileCommand userProfileCommand = new UserProfileCommand();
        UserNotLoggedInException ex = new UserNotLoggedInException();

        String result = userProfileCommand.execute(new ArrayList<LibraryItem>(), new ArrayList<LibraryItem>(), new ArrayList<String>(), new AnonymousUser());

        assertEquals(ex.message, result);
    }

    @Test
    public void shouldReturnUserDataWhenLoggedIn() throws UserNotLoggedInException, LibraryItemNotAvailableException {
        UserProfileCommand userProfileCommand = new UserProfileCommand();
        User loggedUser = new User("Otavio", "omachado@thoughtworks.com", "5381588006", "123-4567");

        String result = userProfileCommand.execute(new ArrayList<LibraryItem>(), new ArrayList<LibraryItem>(), new ArrayList<String>(), loggedUser);

        assertEquals(loggedUser.toString(), result);
    }
}

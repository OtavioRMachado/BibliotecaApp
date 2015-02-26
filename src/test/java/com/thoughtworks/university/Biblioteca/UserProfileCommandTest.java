package com.thoughtworks.university.Biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class UserProfileCommandTest {
    @Test
    public void shouldReturnErrorWhenNotLoggedIn() throws UserNotLoggedInException, LibraryItemNotAvailableException {
        UserProfileCommand userProfileCommand = new UserProfileCommand();
        String result = userProfileCommand.loadCommand(new ArrayList<LibraryItem>(), new ArrayList<LibraryItem>(), new ArrayList<String>(), new AnonymousUser());
        UserNotLoggedInException ex = new UserNotLoggedInException();
        assertEquals(ex.message, result);
    }

    @Test
    public void shouldReturnUserDataWhenLoggedIn() throws UserNotLoggedInException, LibraryItemNotAvailableException {
        UserProfileCommand userProfileCommand = new UserProfileCommand();
        User loggedUser = new User("Otavio", "omachado@thoughtworks.com", "5381588006", "123-4567");
        String result = userProfileCommand.loadCommand(new ArrayList<LibraryItem>(), new ArrayList<LibraryItem>(), new ArrayList<String>(), loggedUser);
        assertEquals(loggedUser.toString(), result);
    }
}

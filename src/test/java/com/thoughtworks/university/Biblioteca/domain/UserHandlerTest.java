package com.thoughtworks.university.Biblioteca.domain;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class UserHandlerTest {
    private User testUser;

    @Test
    public void shouldReturnUserWhenPasswordIsRight() {
        testUser = UsersHandler.log("123-4567", "12345");
        assertTrue(testUser != null);
    }
    @Test
    public void shouldReturnEmptyUserWhenLibraryNoIsNotCorrect() {
        testUser = UsersHandler.log("1234567", "12345");
        assertTrue(testUser.getName() == "");
    }

    @Test
    public void shouldReturnNullWhenPasswordOrLibraryNoDontMatch() {
        testUser = UsersHandler.log("123-4567", "123");
        assertTrue(testUser.getName() == "");

        testUser = UsersHandler.log("123-4568", "12345");
        assertTrue(testUser.getName() == "");
    }
}

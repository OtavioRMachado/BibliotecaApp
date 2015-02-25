package com.thoughtworks.university.Biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class UserHandlerTest {
    @Test
    public void shouldReturnUserWhenPasswordIsRight() {
        User testUser = UsersHandler.log("123-4567", "12345");
        assertTrue(testUser != null);
    }
    @Test
    public void shouldReturnNullWhenLibraryNoIsNotCorrect() {
        User testUser = UsersHandler.log("1234567", "12345");
        assertTrue(testUser == null);
    }

    @Test
    public void shouldReturnNullWhenPasswordOrLibraryNoDontMatch() {
        User testUser = UsersHandler.log("123-4567", "123");
        assertTrue(testUser == null);
        testUser = UsersHandler.log("123-4568", "12345");
        assertTrue(testUser == null);
    }
}

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
<<<<<<< HEAD
    public void shouldReturnEmptyUserWhenLibraryNoIsNotCorrect() {
        User testUser = UsersHandler.log("1234567", "12345");
        assertTrue(testUser.getName() == "");
=======
    public void shouldReturnNullWhenLibraryNoIsNotCorrect() {
        User testUser = UsersHandler.log("1234567", "12345");
        assertTrue(testUser == null);
>>>>>>> abfa025a4c8e07a43fbd556d4dfa21ad46e1a990
    }

    @Test
    public void shouldReturnNullWhenPasswordOrLibraryNoDontMatch() {
        User testUser = UsersHandler.log("123-4567", "123");
<<<<<<< HEAD
        assertTrue(testUser.getName() == "");
        testUser = UsersHandler.log("123-4568", "12345");
        assertTrue(testUser.getName() == "");
=======
        assertTrue(testUser == null);
        testUser = UsersHandler.log("123-4568", "12345");
        assertTrue(testUser == null);
>>>>>>> abfa025a4c8e07a43fbd556d4dfa21ad46e1a990
    }
}

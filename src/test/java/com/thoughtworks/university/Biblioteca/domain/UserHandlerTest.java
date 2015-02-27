package com.thoughtworks.university.Biblioteca.domain;

import com.thoughtworks.university.Biblioteca.domain.User;
import com.thoughtworks.university.Biblioteca.domain.UsersHandler;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class UserHandlerTest {
    @Test
    public void shouldReturnUserWhenPasswordIsRight() {
        User testUser = UsersHandler.log("123-4567", "12345");
        assertTrue(testUser != null);
    }
    @Test
    public void shouldReturnEmptyUserWhenLibraryNoIsNotCorrect() {
        User testUser = UsersHandler.log("1234567", "12345");
        assertTrue(testUser.getName() == "");
    }

    @Test
    public void shouldReturnNullWhenPasswordOrLibraryNoDontMatch() {
        User testUser = UsersHandler.log("123-4567", "123");
        assertTrue(testUser.getName() == "");
        testUser = UsersHandler.log("123-4568", "12345");
        assertTrue(testUser.getName() == "");
    }
}

package com.thoughtworks.university.Biblioteca.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnonymousUserTest {
    @Test
    public void shouldCreateEmptyUser() {
        AnonymousUser anonymousUser = new AnonymousUser();
        assertEquals(anonymousUser.getLibraryNo(), "");
        assertEquals(anonymousUser.getName(), "");
        assertEquals(anonymousUser.getEmail(), "");
        assertEquals(anonymousUser.getPhone(), "");
    }
}

package com.thoughtworks.university.Biblioteca.command;

import com.thoughtworks.university.Biblioteca.domain.LibraryItem;
import com.thoughtworks.university.Biblioteca.domain.LibraryItemNotAvailableException;
import com.thoughtworks.university.Biblioteca.domain.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class OptionsCommandTest {
    @Test
    public void shouldShowMeTheMainMenuWhenExecute() throws LibraryItemNotAvailableException {
        List<String> menuItems = new ArrayList<String>();
        OptionsCommand optionsCommand = new OptionsCommand();
        StringBuilder menuCommands = new StringBuilder();
        User loggedUser = new User("Otavio", "omachado@thoughtworks.com", "05381588006", "12345");

        menuItems.add("Teste");
        menuItems.add("Teste2");
        for (int i = 0; i < menuItems.size(); i++) {
            menuCommands.append(menuItems.get(i));
            if(i < menuItems.size() - 1) {
                menuCommands.append(", ");
            }
        }

        assertEquals("Menu commands: " + menuCommands, optionsCommand.execute(new ArrayList<LibraryItem>(), new ArrayList<LibraryItem>(), menuItems, loggedUser ));
    }
}

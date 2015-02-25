package com.thoughtworks.university.Biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class OptionsCommandTest {
    @Test
    public void shouldShowMeTheMainMenuWhenExecute() throws LibraryItemNotAvailableException {
        List<String> menuItems = new ArrayList<String>();
        menuItems.add("Teste");
        menuItems.add("Teste2");
        OptionsCommand optionsCommand = new OptionsCommand();
        StringBuilder menuCommands = new StringBuilder();
        for (int i = 0; i < menuItems.size(); i++) {
            menuCommands.append(menuItems.get(i));
            if(i < menuItems.size() - 1) {
                menuCommands.append(", ");
            }
        }
        User loggedUser = new User("Otavio", "omachado@thoughtworks.com", "05381588006");
        assertEquals("Menu commands: " + menuCommands, optionsCommand.loadCommand(new ItemHandler(), new ItemHandler(), menuItems, loggedUser ));
    }
}

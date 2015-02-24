package com.thoughtworks.university.Biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class OptionsCommandTest {
    @Test
    public void shouldShowMeTheMainMenuWhenExecute() {
        List<String> menuItems = new ArrayList<String>();
        menuItems.add("Teste");
        menuItems.add("Teste2");
        OptionsCommand optionsCommand = new OptionsCommand(menuItems);
        StringBuilder menuCommands = new StringBuilder();
        for (int i = 0; i < menuItems.size(); i++) {
            menuCommands.append(menuItems.get(i));
            if(i < menuItems.size() - 1) {
                menuCommands.append(", ");
            }
        }
        assertEquals("Menu commands: " + menuCommands, optionsCommand.execute());
    }
}

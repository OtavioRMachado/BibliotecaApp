package com.thoughtworks.university.Biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OptionsCommandTest {
    @Test
    public void shouldShowMeTheMainMenuWhenExecute() {
        StreamControl streamControl = new StreamControl();
        streamControl.setUpOut();
        OptionsCommand optionsCommand = new OptionsCommand();
        optionsCommand.execute();
        StringBuilder menuCommands = new StringBuilder();
        for (int i = 0; i < BibliotecaApp.menuItems.size(); i++) {
            menuCommands.append(BibliotecaApp.menuItems.get(i));
        }
        assertEquals("Menu commands: " + menuCommands + "\n", streamControl.getOutput());
        streamControl.cleanUpStreams();
    }
}

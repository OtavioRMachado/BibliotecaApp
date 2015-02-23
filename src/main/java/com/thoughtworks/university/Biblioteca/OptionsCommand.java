package com.thoughtworks.university.Biblioteca;

public class OptionsCommand extends Command {
    protected static final String commandName = "options";
    public OptionsCommand() {
        //Command.visibleCommands.length()
    }

    public static String getCommandName() {
        return commandName;
    }

    @Override
    public void execute() {
        // Execute OptionsCommand
        StringBuilder menuItems = new StringBuilder();
        for (int i = 0; i < BibliotecaApp.menuItems.size(); i++) {
            menuItems.append(BibliotecaApp.menuItems.get(i));
            if(i < BibliotecaApp.menuItems.size() - 1) {
                menuItems.append(", ");
            }
        }
        System.out.println("Menu commands: " + menuItems);
    }
}

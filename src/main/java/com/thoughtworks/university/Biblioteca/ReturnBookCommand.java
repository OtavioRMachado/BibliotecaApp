package com.thoughtworks.university.Biblioteca;

public class ReturnBookCommand extends Command {
    public static String commandName = "return";
    @Override
    public void execute() {
        // Execute Return Book Command
    }

    public static String getCommandName() {
        return commandName;
    }
}

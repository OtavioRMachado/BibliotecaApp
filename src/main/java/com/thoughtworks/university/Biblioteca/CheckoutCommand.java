package com.thoughtworks.university.Biblioteca;

public class CheckoutCommand extends Command {
    protected static final String commandName = "checkout";
    @Override
    public void execute() {
        // Execute CheckoutCommand
    }

    public static String getCommandName() {
        return commandName;
    }
}

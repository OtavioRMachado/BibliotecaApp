package com.thoughtworks.university.Biblioteca;

public class QuitCommand extends Command {
    public static String commandName = "quit";
    public final String message = "Goodbye!";
    @Override
    public void execute() {
        System.out.print(message);
    }

    public static String getCommandName() {
        return commandName;
    }
}

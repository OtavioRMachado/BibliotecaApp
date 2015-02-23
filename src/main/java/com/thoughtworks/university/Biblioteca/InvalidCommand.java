package com.thoughtworks.university.Biblioteca;

public class InvalidCommand extends Command {
    protected final String message = "Error: Invalid command! To see commands, type OPTIONS";
    @Override
    public void execute() {
        System.out.println(message);
    }
}

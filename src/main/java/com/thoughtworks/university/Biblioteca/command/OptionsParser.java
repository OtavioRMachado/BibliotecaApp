package com.thoughtworks.university.Biblioteca.command;

public class OptionsParser extends ParserCommand {
    @Override
    public Command execute(String line) {
        return new OptionsCommand();
    }
}

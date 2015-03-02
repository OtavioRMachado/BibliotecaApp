package com.thoughtworks.university.Biblioteca.command;

public class QuitParser extends ParserCommand {
    @Override
    public Command execute(String line) {
        return new QuitCommand();
    }
}

package com.thoughtworks.university.Biblioteca.command;

public class ListMoviesParser extends ParserCommand {
    @Override
    public Command execute(String line) {
        return new ListMoviesCommand();
    }
}

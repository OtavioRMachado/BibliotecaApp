package com.thoughtworks.university.Biblioteca.command;

public class ListBooksParser extends ParserCommand {
    @Override
    public Command execute(String line) {
        return new ListBooksCommand();
    }
}

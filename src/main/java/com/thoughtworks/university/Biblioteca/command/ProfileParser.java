package com.thoughtworks.university.Biblioteca.command;

public class ProfileParser extends ParserCommand {

    @Override
    public Command execute(String line) {
        return new UserProfileCommand();
    }
}

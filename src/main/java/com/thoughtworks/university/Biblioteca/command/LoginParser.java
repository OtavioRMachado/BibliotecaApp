package com.thoughtworks.university.Biblioteca.command;

public class LoginParser extends ParserCommand {
    @Override
    public Command execute(String line) {
        String[] lineList = line.split(" ");
        if(lineList.length == 3) {
            return new LoginCommand(lineList[1], lineList[2]);
        }
        return new InvalidCommand();
    }
}

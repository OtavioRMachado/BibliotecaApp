package com.thoughtworks.university.Biblioteca.command;

public class CheckoutParser extends ParserCommand {
    @Override
    public Command execute(String line) {
        String[] lineList = line.split(" ");
        int value;
        try {
            value = Integer.parseInt(lineList[lineList.length-1]);
        } catch(NumberFormatException exception) {
            return new InvalidCommand();
        }
        return new CheckoutCommand(value);
    }
}

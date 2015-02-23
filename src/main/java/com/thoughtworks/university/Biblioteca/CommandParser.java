package com.thoughtworks.university.Biblioteca;

import javax.swing.text.html.Option;

public class CommandParser {
    public static Command parseCommand(String line) {
        if(line.toLowerCase().equals(OptionsCommand.getCommandName())) {
            return new OptionsCommand();
        }
        else if(line.toLowerCase().equals(CheckoutCommand.getCommandName())) {
            return new CheckoutCommand();
        }
        else if(line.toLowerCase().equals(ReturnBookCommand.getCommandName())) {
            return new ReturnBookCommand();
        }
        else if(line.toLowerCase().equals(QuitCommand.getCommandName())) {
            return new QuitCommand();
        }
        else if(line.toLowerCase().equals(ListBooksCommand.getCommandName())) {
            return new ListBooksCommand();
        }
        else {
            return new InvalidCommand();
        }
    }
}

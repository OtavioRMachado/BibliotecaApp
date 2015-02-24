package com.thoughtworks.university.Biblioteca;

import java.util.List;

public class CommandParser {
    public static Command parseCommand(String line, BookHandler availableBooks, BookHandler borrowedBooks, List<String> menuItems) {
        if(line.toLowerCase().contains(OptionsCommand.getCommandName())) {
            return new OptionsCommand(menuItems);
        }
        else if(line.toLowerCase().contains(CheckoutCommand.getCommandName())) {
            String[] lineList = line.split(" ");
            int value;
            try {
                value = Integer.parseInt(lineList[lineList.length-1]);
            } catch(NumberFormatException exception) {
                return new InvalidCommand();
            }
            return new CheckoutCommand(value);
        }
        else if(line.toLowerCase().contains(ReturnBookCommand.getCommandName())) {
            String[] lineList = line.split(" ");
            int value;
            try {
                value = Integer.parseInt(lineList[lineList.length-1]);
            } catch(NumberFormatException exception) {
                return new InvalidCommand();
            }
            return new ReturnBookCommand(value);
        }
        else if(line.toLowerCase().contains(QuitCommand.getCommandName())) {
            return new QuitCommand();
        }
        else if(line.toLowerCase().contains(ListBooksCommand.getCommandName())) {
            return new ListBooksCommand();
        }
        else {
            return new InvalidCommand();
        }
    }
}

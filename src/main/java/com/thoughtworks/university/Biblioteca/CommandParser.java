package com.thoughtworks.university.Biblioteca;

public class CommandParser {
    public static Command parseCommand(String line) {
        if(isOptionsCommand(line)) {
            return new OptionsCommand();
        }
        if(isCheckoutCommand(line)) {
            String[] lineList = line.split(" ");
            int value;
            try {
                value = Integer.parseInt(lineList[lineList.length-1]);
            } catch(NumberFormatException exception) {
                return new InvalidCommand();
            }
            return new CheckoutCommand(value);
        }
        if(isReturnBookCommand(line)) {
            String[] lineList = line.split(" ");
            int value;
            try {
                value = Integer.parseInt(lineList[lineList.length-1]);
            } catch(NumberFormatException exception) {
                return new InvalidCommand();
            }
            return new ReturnItemCommand(value);
        }
        if(isQuitCommand(line)) {
            return new QuitCommand();
        }
        if(isListBooksCommand(line)) {
            return new ListBooksCommand();
        }
        return new InvalidCommand();
    }

    private static boolean isListBooksCommand(String line) {
        return line.toLowerCase().contains(ListBooksCommand.getCommandName());
    }

    private static boolean isQuitCommand(String line) {
        return line.toLowerCase().contains(QuitCommand.getCommandName());
    }

    private static boolean isReturnBookCommand(String line) {
        return line.toLowerCase().contains(ReturnItemCommand.getCommandName());
    }

    private static boolean isCheckoutCommand(String line) {
        return line.toLowerCase().contains(CheckoutCommand.getCommandName());
    }

    private static boolean isOptionsCommand(String line) {
        return line.toLowerCase().contains(OptionsCommand.getCommandName());
    }
}

package com.thoughtworks.university.Biblioteca.command;

/*
 * Responsibility: Defines what command has been written by the user.
 */
public class CommandParser {
    public static Command parseCommand(String line) {
        String[] lineList = line.split(" ");
        if(isOptionsCommand(lineList[0])) {
            return new OptionsCommand();
        }
        if(isCheckoutCommand(lineList[0])) {
            int value;
            try {
                value = Integer.parseInt(lineList[lineList.length-1]);
            } catch(NumberFormatException exception) {
                return new InvalidCommand();
            }
            return new CheckoutCommand(value);
        }
        if(isReturnBookCommand(lineList[0]) && lineList.length == 2) {
            int value;
            try {
                value = Integer.parseInt(lineList[lineList.length-1]);
            } catch(NumberFormatException exception) {
                return new InvalidCommand();
            }
            return new ReturnItemCommand(value);
        }
        if(isQuitCommand(lineList[0])) {
            return new QuitCommand();
        }
        if(isListBooksCommand(line)) {
            return new ListBooksCommand();
        }
        if(isLoginCommand(lineList[0]) && lineList.length == 3) {
            return new LoginCommand(lineList[1], lineList[2]);
        }
        if(isListMoviesCommand(line)) {
            return new ListMoviesCommand();
        }
        if(isUserProfileCommand(lineList[0])) {
            return new UserProfileCommand();
        }
        return new InvalidCommand();
    }

    private static boolean isUserProfileCommand(String line) {
        return line.toLowerCase().contains(UserProfileCommand.getCommandName());
    }

    private static boolean isListMoviesCommand(String line) {
        return line.toLowerCase().contains(ListMoviesCommand.getCommandName());
    }

    private static boolean isLoginCommand(String line) {
        return line.toLowerCase().contains(LoginCommand.getCommandName());
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
